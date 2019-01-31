-- :name insert-price! :! :n
-- :doc genera un un registros en la base de precios
INSERT INTO precios
("desc", "code", "price", "lista", "fecha")
VALUES (:desc, :code, :price, :lista, :fecha)

-- :name update-price! :! :n
-- :doc updates an existing price record
UPDATE precios
SET desc = :desc, price = :price, fecha = :fecha
WHERE code = :code

-- :name get-price :? :1
-- :doc retrieves a price record given the code
SELECT * FROM precios
WHERE code = :code

-- :name get-price-by-date :? :*
-- :doc retrieves a price record given the code
SELECT * FROM precios
WHERE fecha = :fecha

-- :name delete-price! :! :n
-- :doc deletes a price record given the code
DELETE FROM precios
WHERE id = :code

-- :name get-all-prices :? :*
-- :doc get all the prices list
SELECT * FROM precios

-- :name get-loaded-dates :? :*
-- :doc get last date from spreadsheets
SELECT fecha FROM precios GROUP BY fecha ORDER BY fecha DESC limit 1

-- :name get-all-dates :? :*
-- :doc get all dates loaded on spreadsheet database
SELECT fecha FROM precios GROUP BY fecha ORDER BY fecha DESC

-- :name get-loaded-lists :? :*
-- :doc get all diferentes loaded spreadsheets.
SELECT count(*) as registros,  LISTA, FECHA FROM PRECIOS GROUP BY LISTA, FECHA ORDER BY LISTA, FECHA DESC

-- :name delete-lista! :! :n
-- :doc delete all lists by list-name and date.
DELETE FROM precios
WHERE LISTA = :lista AND fecha = :fecha