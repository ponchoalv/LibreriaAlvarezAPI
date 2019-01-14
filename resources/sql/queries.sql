-- :name insert-price! :! :n
-- :doc genera un un registros en la base de precios
INSERT INTO precios
(desc, code, price, fecha)
VALUES (:desc, :code, :price, :fecha)

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
DELETE FROM precio
WHERE id = :code

-- :name get-all-prices :? :*
-- :doc get all the prices list
SELECT * FROM precios
