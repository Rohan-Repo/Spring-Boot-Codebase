CREATE DATABASE FakerDataDB;

USE FakerDataDB;

create user 'fakerdbadmin'@'localhost' IDENTIFIED BY 'fakerdbadmin';

grant all privileges on *.* to 'fakerdbadmin'@'localhost' with GRANT option;

SHOW TABLES;

SELECT * FROM Address;

SELECT * FROM Person;

SELECT 
	CONCAT(first_name, ' ', last_name) AS personName, 
    birth_date,
    age,
    email_address,
    phone_number,
    address,
    city,
    state,
    zip
FROM 
	Person
INNER JOIN 
	Address 
ON 
	Person.address_id = Address.Id
ORDER BY age DESC;