(ns libreria-alvarez-api.excel-etl.core
  (:require [dk.ative.docjure.spreadsheet :as s])
  (:import (java.util Date)
           (java.text DecimalFormat)))

(def know-columns-maps {:powerland {:A :code
                                    :B :desc
                                    :C :price}
                        :yo-yo {:A :desc
                                :B :code
                                :D :price}})

(def decimal-format (DecimalFormat. "#.###.###.##0,00"))

(defn ^:private filter-data [{:keys [code desc price]}]
  (and (not (nil? code))
       (not (nil? desc))
       (not (nil? price))))

(defn ^:private format-data [spreadsheet-name fecha columns-data]
  (let [{:keys [code desc price]} columns-data]
    {:code  (clojure.string/upper-case (clojure.string/trim (str code)))
     :desc  (clojure.string/upper-case (clojure.string/trim desc))
     :price (.parse decimal-format (clojure.string/replace (str price) "." ","))
     :lista (clojure.string/upper-case spreadsheet-name)
     :fecha fecha}))

(defn load-spread-sheet [stream sheet-name columns-map spreadsheet-name spreadsheet-date]
   (->> (s/load-workbook stream)
          (s/select-sheet sheet-name)
          (s/select-columns columns-map)
          (filter filter-data)
          (rest)
          (mapv (partial format-data spreadsheet-name spreadsheet-date))))

;; Ejemplos de como usar la API.
(def loaded-powerland-sheet
  (load-spread-sheet
    (clojure.java.io/input-stream
      (clojure.java.io/file "planillas/powerland.xls"))
    "precios"
    (:powerland know-columns-maps) "powerland" (Date.)))

(def loaded-yoyo-sheet
  (load-spread-sheet
    (clojure.java.io/input-stream
      (clojure.java.io/file "planillas/lego.xls"))
    "precios"
    (:yo-yo know-columns-maps) "yoyo" (Date.)))

(def loaded-toys-yoyo-sheet
  (load-spread-sheet
    (clojure.java.io/input-stream
      (clojure.java.io/file "planillas/toys.xls"))
    "precios"
    (:yo-yo know-columns-maps) "yoyo-toys" (Date.)))
