(ns libreria.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [schema.core :as s]
            [libreria.excel-service-provider.core :as price-service])
  (:import (java.time LocalDate)))

(s/defschema PriceList [{:desc  s/Str
                         :code  s/Str
                         :price s/Num
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

      (POST "/minus" []
        :return      Long
        :body-params [x :- Long, y :- Long]
        :summary     "x-y with body-parameters."
        (ok (- x y)))

      (GET "/prices-by-fecha" []
        :return      PriceList
        :query-params [fecha :- s/Str]
        :summary     "Return prices on a certain date"
        (ok (price-service/retrieve-all-prices-by-date fecha)))

      (POST "/divide" []
        :return      Double
        :form-params [x :- Long, y :- Long]
        :summary     "x/y with form-parameters"
        (ok (/ x y)))

      (GET "/power" []
        :return      Long
        :header-params [x :- Long, y :- Long]
        :summary     "x^y with header-parameters"
        (ok (long (Math/pow x y)))))))
