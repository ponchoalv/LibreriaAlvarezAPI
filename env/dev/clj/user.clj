(ns user
  (:require [libreria.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [libreria.figwheel :refer [start-fw stop-fw cljs]]
            [libreria.core :refer [start-app]]
            [libreria.db.core]
            [conman.core :as conman]
            [luminus-migrations.core :as migrations]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'libreria.core/repl-server))

(defn stop []
  (mount/stop-except #'libreria.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn restart-db []
  (mount/stop #'libreria.db.core/*db*)
  (mount/start #'libreria.db.core/*db*)
  (binding [*ns* 'libreria.db.core]
    (conman/bind-connection libreria.db.core/*db* "sql/queries.sql")))

(defn reset-db []
  (migrations/migrate ["reset"] (select-keys env [:database-url])))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration [name]
  (migrations/create name (select-keys env [:database-url])))


