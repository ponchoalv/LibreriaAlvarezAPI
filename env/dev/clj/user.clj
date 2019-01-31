(ns user
  (:require [libreria-alvarez-api.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [libreria-alvarez-api.core :refer [start-app]]
            [libreria-alvarez-api.db.core]
            [conman.core :as conman]
            [luminus-migrations.core :as migrations]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'libreria-alvarez-api.core/repl-server))

(defn stop []
  (mount/stop-except #'libreria-alvarez-api.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn restart-db []
  (mount/stop #'libreria-alvarez-api.db.core/*db*)
  (mount/start #'libreria-alvarez-api.db.core/*db*)
  (binding [*ns* 'libreria-alvarez-api.db.core]
    (conman/bind-connection libreria-alvarez-api.db.core/*db* "sql/queries.sql")))

(defn reset-db []
  (migrations/migrate ["reset"] (select-keys env [:database-url])))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration [name]
  (migrations/create name (select-keys env [:database-url])))


