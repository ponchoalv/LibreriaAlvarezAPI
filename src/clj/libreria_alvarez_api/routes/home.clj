(ns libreria-alvarez-api.routes.home
  (:require [libreria-alvarez-api.layout :as layout]
            [libreria-alvarez-api.db.core :as db]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))


(defroutes home-routes
  (GET "/" [] {:status  200
               :headers {"Content-Type" "text/html"}
               :body    (io/file "resources/public/index.html")}))

