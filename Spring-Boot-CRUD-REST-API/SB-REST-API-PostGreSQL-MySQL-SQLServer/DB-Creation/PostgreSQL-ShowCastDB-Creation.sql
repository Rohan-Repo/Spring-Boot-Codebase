-- Database: ShowCastDB

-- DROP DATABASE IF EXISTS "ShowCastDB";

CREATE DATABASE "ShowCastDB"
    WITH
    OWNER = showcastdbadmin
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Role: showcastdbadmin
-- DROP ROLE IF EXISTS showcastdbadmin;

CREATE ROLE showcastdbadmin WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION
  ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:0RVuSxO91GtqiYrLfErkfg==$MTcNegC7XdrDlh1D2AYB+luqc2PKVsvewcHeN6sz+v8=:xOEqBWooeI/RibHzXwclgJ/GxfFIcthcsbm4gaO1lPU=';
  
-- DB and User needs to be created but the Table is created via SpringBoot Code
-- INSERT Data into Table
INSERT INTO show_character_actor_names 
	( actor_id, show_name, actor_show_name, actor_real_name )
VALUES
	( '076e820d-9377-47ae-a820-690a3c5cbd3a', 'Friends', 'Chandler Bing', 'Matthew Perry' ),
	( '811d0fb4-4f35-4118-8050-ad21a34e6337', 'Lie to me', 'Cal Lightman', 'Tim Roth' ),
	( 'd5ef7b76-4369-4b2e-808a-1b8cd0abc4e7', 'Friends', 'Joey Tribbiani', 'Matt Leblanc' ),
  ( 'c9cbaa4b-986b-4e04-85af-d61c634bb562', 'Revenge', 'Emily Thorne', 'Emily Vancamp' ),
  ( '3e3588f2-4921-4009-8996-a66ef485bfa8', 'Lie to me', 'Gillian Foster', 'Kelli Williams' ),
	( '14446175-d750-4d26-ba85-8604373829b5', 'Arrow', 'Oliver Queen', 'Stephen Amell' ),
	( '74949414-57a9-49f7-8d02-b980ecc5a588', 'Scandal', 'Olivia Pope', 'Kerry Washington' ),
	( 'e81ec45e-7ec0-43eb-960a-ed748457df87', 'Forever', 'Dr. Henry Morgan', 'Ioan Gruffudd' );

SELECT * FROM show_character_actor_names ORDER BY show_name;