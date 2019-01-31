(ns libreria-alvarez-api.handler
  (:require [libreria-alvarez-api.middleware :as middleware]
            [libreria-alvarez-api.layout :refer [error-page]]
            [libreria-alvarez-api.routes.home :refer [home-routes]]
            [libreria-alvarez-api.routes.services :refer [service-routes]]
            [compojure.core :refer [routes wrap-routes]]
            [ring.util.http-response :as response]
            [compojure.route :as route]
            [libreria-alvarez-api.env :refer [defaults]]
            [mount.core :as mount]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
      (-> #'home-routes
          (wrap-routes middleware/wrap-csrf)
          (wrap-routes middleware/wrap-formats))
      #'service-routes
      (route/not-found
        (:body
          (error-page {:status 404
                       :title "page not found"}))))))

