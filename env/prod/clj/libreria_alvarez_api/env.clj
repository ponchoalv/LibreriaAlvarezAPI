(ns libreria-alvarez-api.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[libreria-alvarez-api started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[libreria-alvarez-api has shut down successfully]=-"))
   :middleware identity})
