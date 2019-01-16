(ns libreria.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [schema.core :as s]
            [libreria.excel-service-provider.core :as price-service]
            [ring.swagger.upload :as upload]
            [libreria.excel-etl.core :as etl])
  (:import (java.time LocalDate)))

(s/defschema PriceList [{:desc  s/Str
                         :code  s/Str
                         :price s/Num
                         :lista s/Str
                         :fecha LocalDate}])

(s/defschema PriceListDates [{:fecha LocalDate}])

(s/defschema TipoLista (s/enum :powerland :yo-yo))

(s/defschema NombreLista (s/enum "POWERLAND" "YOYO" "YOYO-TOYS"))

(s/defschema ListasCargadas [{:registros s/Int
                              :lista s/Str
                              :fecha LocalDate}])

(def service-routes
  (api
    {:swagger {:ui "/swagger-ui"
               :spec "/swagger.json"
               :data {:info {:version "1.0.0"
                             :title "API Libreria ALvarez"
                             :description "API utilizada para la carga y consulta de precios."}}}}
    
    (context "/api" []
      :tags ["libreria alvarez"]
      
      (GET "/all-prices" []
        :return       PriceList
        :summary      "Return all prices on de DB"
        (ok (price-service/retrieve-all-prices)))

      (POST "/cargar-lista" []
        :multipart-params [file :- upload/TempFileUpload,
                           fecha :- LocalDate,
                           tipo-lista :- TipoLista,
                           nombre-lista :- NombreLista,
                           nombre-hoja :- s/Str]
        :summary     "Cargar una planilla con una lista y fecha especifica,
        el nombre de la hoja de la lista debe ser 'precios'"
        (ok (let [lista-in-memory (etl/load-spread-sheet
                                       (clojure.java.io/input-stream
                                         (clojure.java.io/file (:tempfile file)))
                                       nombre-hoja
                                       (tipo-lista etl/know-columns-maps) nombre-lista fecha)]
              (price-service/load-datasheet-on-db lista-in-memory)
              {:success true})))

      (GET "/prices-by-fecha" []
        :return      PriceList
        :query-params [fecha :- LocalDate]
        :summary     "Return prices on a certain date"
        (ok (price-service/retrieve-all-prices-by-date fecha)))

      (GET "/get-last-date" []
        :return      LocalDate
        :summary     "Return last date loaded"
        (ok (price-service/retrieve-last-date)))

      (GET "/get-all-dates" []
        :return      PriceListDates
        :summary     "Return all dates loaded"
        (ok (price-service/retrieve-all-dates)))

      (GET "/get-all-loaded-lists" []
              :return      ListasCargadas
              :summary     "Return last date loaded"
              (ok (price-service/get-all-loaded-lists)))

      (POST "/delete-list-by-date-and-name" []
        :return      s/Int
        :body-params [lista :- s/Str, fecha :- LocalDate]
        :summary     "Eliminar una lista por Nombre y Fecha"
        (ok (price-service/delete-list-by-date-and-name lista fecha))))))
