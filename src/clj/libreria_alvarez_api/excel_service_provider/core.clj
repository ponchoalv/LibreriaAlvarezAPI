(ns libreria-alvarez-api.excel-service-provider.core
  (:require [libreria-alvarez-api.excel-etl.core :as etl]
            [libreria-alvarez-api.db.core :as db])
  (:import (java.text SimpleDateFormat)
           (java.time LocalDate)))

(def date-formatter (SimpleDateFormat. "yyyy-MM-dd"))

(defn load-datasheet-on-db-json [fecha lista datasheet]
   (db/insert-price-list! {:fecha   fecha
                           :lista   lista
                           :precios {:data datasheet}}))

(defn retrieve-all-prices-by-date-json [date]
  (let [xform (map #(get-in % [:precios :data]))]
    (transduce xform concat (db/get-price-lists {:fecha date}))))

(defn retrieve-last-date-json []
  (let [last-date (:fecha (first (db/get-loaded-dates-json)))]
    (if (not last-date)
      (LocalDate/now)
      last-date)))

(defn retrieve-all-dates-json []
  (db/get-all-dates-json))

(defn get-all-loaded-lists-json []
  (db/get-loaded-lists-json))


(defn delete-list-by-date-and-name [lista fecha]
  (db/delete-lista! {:lista lista
                     :fecha fecha}))

(defn delete-list-by-date-and-name-json [lista fecha]
  (db/delete-lista-json! {:lista lista
                          :fecha fecha}))
