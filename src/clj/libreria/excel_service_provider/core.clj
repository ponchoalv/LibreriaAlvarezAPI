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
  (db/get-price-by-date {:fecha (.parse date-formatter date)}))

;; ejemplos de como usar la API

(def load-example-data-on-db (load-datasheet-on-db etl/loaded-yoyo-sheet))
