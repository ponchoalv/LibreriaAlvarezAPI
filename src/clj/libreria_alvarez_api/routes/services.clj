(ns libreria-alvarez-api.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [schema.core :as s]
            [compojure.api.meta :refer [restructure-param]]
            [buddy.auth.accessrules :refer [restrict]]
            [buddy.auth :refer [authenticated?]]
            [libreria-alvarez-api.excel-service-provider.core :as price-service]
            [ring.swagger.upload :as upload]
            [libreria-alvarez-api.excel-etl.core :as etl]
            [libreria-alvarez-api.login-service.core :as login]
            [libreria-alvarez-api.db.core :as db])
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

(s/defschema PriceListJson [{:desc  s/Str
                         :code  s/Str
                         :price s/Num
                         :lista s/Str
                         :fecha s/Str}])

(s/defschema PriceListDates [{:fecha LocalDate}])

(s/defschema TipoLista (s/enum :powerland :yo-yo))

(s/defschema ListasCargadas [{:registros s/Int
                              :lista s/Str
                              :fecha LocalDate}])

(s/defschema LoginResponse {:token s/Str})

(s/defschema SuccessResponse {:result s/Str})

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
              (price-service/load-datasheet-on-db-json fecha nombre-lista lista-in-memory)
              {:success true})))

      (POST "/login" []
        :return LoginResponse
        :multipart-params [username :- s/Str
                      password :- s/Str]
        :summary "Metodo utilizado para el login de usuarios."
        (login/login-handler {:username username
                              :password password}))

      (POST "/add-user" []
        :return SuccessResponse
        :multipart-params [username :- s/Str
                      password :- s/Str]
        :summary "Metodo utilizado para el registro de usuarios"
        (login/add-user! username password))

      (GET "/prices-by-fecha" []
        :return      PriceListJson
        :query-params [fecha :- LocalDate]
        :summary     "Return prices on a certain date"
        (ok (price-service/retrieve-all-prices-by-date-json fecha)))

      (GET "/get-last-date" []
        :return      LocalDate
        :summary     "Return last date loaded"
        (ok (price-service/retrieve-last-date-json)))

      (GET "/get-all-dates" []
        :return      PriceListDates
        :summary     "Return all dates loaded"
        (ok (price-service/retrieve-all-dates-json)))

      (GET "/get-all-loaded-lists" []
        :return      ListasCargadas
        :summary     "Return last date loaded"
        (ok (price-service/get-all-loaded-lists-json)))

      (POST "/delete-list-by-date-and-name" []
        :return      s/Int
        :body-params [lista :- s/Str, fecha :- LocalDate]
        :summary     "Eliminar una lista por Nombre y Fecha"
        (ok (price-service/delete-list-by-date-and-name-json lista fecha)))

      (GET "/get-list-types" []
        :return  s/Any
        :summary      "Los tipos de lista excel soportados por el sistema"
        (ok (rest (s/explain TipoLista))))

      (GET "/get-ventas-by-day" []
        :return s/Any
        :query-params [fecha :- s/Str]
        :summary "obtener las ventas por día"
        (ok (db/get-ventas-by-day {:dia-ventas fecha})))

      (GET "/get-ventas" []
        :return s/Any
        :summary "obtener todas las ventas cargadas en la base"
        (ok (db/get-ventas)))

      (POST "/add-venta" []
        :body-params [monto :- s/Num, usuario :- s/Str]
        :summary "carga una venta para un día especifico, y un usuario especifico"
        (ok (db/add-venta! {:monto monto :usuario usuario})))

      (GET "/get-fechas-con-ventas" []
        :return s/Any
        :summary "obtner todas las fechas donde hubo ventas"
        (ok (db/get-dates-with-sales)))
      (POST "/remove-sale-by-date" []
        :return s/Int
        :body-params [fecha :- s/Str]
        :summary "obtiene la fecha en formato 2019-08-22T00:05:16.812272 y elimina el registro de la venta"
        (ok (db/delete-venta-by-date! {:fecha (clojure.string/replace fecha "T" " ")}))))))
