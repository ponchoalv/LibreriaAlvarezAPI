(ns libreria-alvarez-api.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [libreria-alvarez-api.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[libreria-alvarez-api started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[libreria-alvarez-api has shut down successfully]=-"))
   :middleware wrap-dev})
