-- Create the Database
CREATE DATABASE ShowCastDB;

-- Choose the Database
USE ShowCastDB;

SHOW TABLES;

DESC show_character_actor_names;

CREATE TABLE `show_character_actor_names` (
  `show_id` binary(16) NOT NULL,
  `actor_real_name` varchar(255) NOT NULL,
  `actor_show_name` varchar(255) DEFAULT NULL,
  `show_name` varchar(255) NOT NULL,
  PRIMARY KEY (`show_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
