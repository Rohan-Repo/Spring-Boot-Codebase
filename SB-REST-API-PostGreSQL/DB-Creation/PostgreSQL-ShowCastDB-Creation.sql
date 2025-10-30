-- Database: ShowCastDB

-- DROP DATABASE IF EXISTS "ShowCastDB";

-- DB Creation
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

-- User Creation
CREATE ROLE showcastdbadmin WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION
  ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:0RVuSxO91GtqiYrLfErkfg==$MTcNegC7XdrDlh1D2AYB+luqc2PKVsvewcHeN6sz+v8=:xOEqBWooeI/RibHzXwclgJ/GxfFIcthcsbm4gaO1lPU=';
  
-- Generate ActorData using INSERT Statement
INSERT INTO show_character_actor_names 
	( actor_id, show_name, actor_show_name, actor_real_name )
VALUES
	( gen_random_uuid(), 'Friends', 'Chandler Bing', 'Matthew Perry' ),
	( gen_random_uuid(), 'Lie to me', 'Cal Lightman', 'Tim Roth' ),
	( gen_random_uuid(), 'Friends', 'Joey Tribbiani', 'Matt Leblanc' ),
    ( gen_random_uuid(), 'Revenge', 'Emily Thorne', 'Emily Vancamp' ),
    ( gen_random_uuid(), 'Lie to me', 'Gillian Foster', 'Kelli Williams' ),
	( gen_random_uuid(), 'Arrow', 'Oliver Queen', 'Stephen Amell' ),
	( gen_random_uuid(), 'Scandal', 'Olivia Pope', 'Kerry Washington' ),
	( gen_random_uuid(), 'Forever', 'Dr. Henry Morgan', 'Ioan Gruffudd' );

SELECT * FROM show_character_actor_names ORDER BY show_name;