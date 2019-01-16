(ns libreria.excel-service-provider.core
  (:require [libreria.excel-etl.core :as etl]
            [libreria.db.core :as db])
  (:import (java.text SimpleDateFormat)))

(def date-formatter (SimpleDateFormat. "yyyy-MM-dd"))

(defn load-datasheet-on-db [datasheet]
  (doall
    (map #(db/insert-price! %) datasheet)))

(defn retrieve-all-prices []
  (db/get-all-prices))

(defn retrieve-all-prices-by-date [date]
  (db/get-price-by-date {:fecha date}))

(defn retrieve-last-date []
  (:fecha (first (db/get-loaded-dates))))

(defn retrieve-all-dates []
  (db/get-all-dates))

(defn get-all-loaded-lists []
  (db/get-loaded-lists))

(defn delete-list-by-date-and-name [lista fecha]
  (db/delete-lista! {:lista lista
                     :fecha fecha}))


;; ejemplos de como usar la API

;; (def load-example-data-on-db (load-datasheet-on-db etl/loaded-yoyo-sheet))
