(ns libreria-alvarez-api.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [schema.core :as s]
            [compojure.api.meta :refer [restructure-param]]
            [buddy.auth.accessrules :refer [restrict]]
            [buddy.auth :refer [authenticated?]]
            [libreria-alvarez-api.excel-service-provider.core :as price-service]
            [ring.swagger.upload :as upload]
            [libreria-alvarez-api.excel-etl.core :as etl])
  (:import (java.time LocalDate)))

(defn access-error [_ _]
  (unauthorized {:error "unauthorized"}))

(defn wrap-restricted [handler rule]
  (restrict handler {:handler  rule
                     :on-error access-error}))

(defmethod restructure-param :auth-rules
  [_ rule acc]
  (update-in acc [:middleware] conj [wrap-restricted rule]))

(defmethod restructure-param :current-user
  [_ binding acc]
  (update-in acc [:letks] into [binding `(:identity ~'+compojure-api-request+)]))

(s/defschema PriceList [{:desc  s/Str
                         :code  s/Str
                         :price s/Num
                         :lista s/Str
                         :fecha LocalDate}])

(s/defschema PriceListDates [{:fecha LocalDate}])

(s/defschema TipoLista (s/enum :powerland :yo-yo))

(s/defschema ListasCargadas [{:registros s/Int
                              :lista s/Str
                              :fecha LocalDate}])

(def service-routes
  (api
    {:swagger {:ui "/swagger-ui"
               :spec "/swagger.json"
               :data {:info {:version "1.0.0"
                             :title "Sample API"
                             :description "Sample Services"}}}}

    (GET "/authenticated" []
         :auth-rules authenticated?
         :current-user user
         (ok {:user user}))

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
                           nombre-lista :- s/Str,
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
        (ok (price-service/delete-list-by-date-and-name lista fecha)))

      (GET "/get-list-types" []
        :return  s/Any
        :summary      "Los tipos de lista excel soportados por el sistema"
        (ok (rest (s/explain TipoLista)))))))
