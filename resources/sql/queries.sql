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

-- :name add-venta! :! :N
-- :doc add a sale to the database
INSERT INTO ventas
(monto, usuario) VALUES (:monto, :usuario)

-- :name get-ventas-by-day :? :*
-- :doc get sales for a specific date
SELECT * FROM ventas
WHERE cast(DATE_TRUNC('day', fecha) as varchar(10)) = :dia-ventas
ORDER BY fecha DESC

-- :name get-ventas :? :*
-- :doc get all loaded sales
SELECT * FROM ventas

-- :name get-dates-with-sales :? :*
-- :doc get all dates where a sale was done
SELECT cast(DATE_TRUNC('day', fecha)  as varchar(10)) as fecha FROM ventas GROUP BY cast(DATE_TRUNC('day', fecha) as varchar(10)) ORDER BY cast(DATE_TRUNC('day', fecha) as varchar(10)) DESC

-- :name delete-venta-by-date! :! :n
-- :doc delete an specific date
DELETE FROM ventas WHERE cast(fecha as varchar(26)) = :fecha