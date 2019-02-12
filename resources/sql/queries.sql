-- :name insert-price-list! :! :n
-- :doc insert a price list on the database
INSERT INTO precios_json
(fecha, lista, precios) VALUES (:fecha, :lista, :precios)

-- :name get-price-lists :? :*
-- :doc get all price lists
SELECT * FROM precios_json
WHERE fecha = :fecha

-- :name get-loaded-dates-json :? :*
-- :doc get last date from spreadsheets
SELECT fecha FROM precios_json GROUP BY fecha ORDER BY fecha DESC limit 1

-- :name get-all-dates-json :? :*
-- :doc get all dates loaded on spreadsheet database
SELECT fecha FROM precios_json GROUP BY fecha ORDER BY fecha DESC

-- :name get-loaded-lists-json :? :*
-- :doc get all diferentes loaded spreadsheets.
SELECT json_array_length(precios -> 'data') as registros, lista, fecha FROM precios_json ORDER BY fecha DESC, lista ASC

-- :name delete-lista-json! :! :n
-- :doc delete all lists by list-name and date.
DELETE FROM precios_json
WHERE LISTA = :lista AND fecha = :fecha

-- :name login :? :*
-- :doc find user login
SELECT username FROM users
WHERE username = :username AND password = :password

-- :name add-user! :! :n
-- :doc find user login
INSERT INTO users
(username, password) VALUES (:username, :password)