(ns libreria.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[libreria started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[libreria has shut down successfully]=-"))
   :middleware identity})
