(ns libreria-alvarez-api.login-service.core
  (:require
    [buddy.sign.jwt :as jwt]
    [buddy.auth.backends :as backends]
    [buddy.auth.middleware :refer (wrap-authentication)]
    [ring.util.http-response :refer [ok unauthorized]]
    [libreria-alvarez-api.db.core :as db]))

(def secret "blueturtle15")
(def backend (backends/jws {:secret secret
                            :options {:alg :rsa-oaep
                                      :enc :a128-hs256}}))

(defn login-handler
  [data]
  (let [user (db/login {:username (:username data)
                        :password (:password data)})
        token (jwt/sign {:user (:username data)} secret)]
    (if (empty? user)
      (unauthorized {:error "Invalid username or password"})
      (ok {:token token}))))


(defn add-user! [username password]
  (if (> (db/add-user! {:username username
                        :password password})
         0)
    (ok {:result "success"})))