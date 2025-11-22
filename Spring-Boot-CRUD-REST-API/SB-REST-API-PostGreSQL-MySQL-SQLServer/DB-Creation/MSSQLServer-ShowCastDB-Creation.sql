-- 1. Create the database
CREATE DATABASE ShowCastDB;
GO

-- 2. Create a login for the application
CREATE LOGIN showcastdbadmin WITH PASSWORD = 'MSSQLAdmin';
GO

-- 3. Create a user in the database for the login
USE ShowCastDB;
GO
CREATE USER showcastdbadmin FOR LOGIN showcastdbadmin;
GO

-- 4. Grant necessary permissions
ALTER ROLE db_owner ADD MEMBER showcastdbadmin;
GO

-- Generate ActorData using INSERT Statement
INSERT INTO show_character_actor_names 
	( actor_id, show_name, actor_show_name, actor_real_name )
VALUES
	( NEWID(), 'Friends', 'Chandler Bing', 'Matthew Perry' ),
	( NEWID(), 'Lie to me', 'Cal Lightman', 'Tim Roth' ),
	( NEWID(), 'Friends', 'Joey Tribbiani', 'Matt Leblanc' ),
    ( NEWID(), 'Revenge', 'Emily Thorne', 'Emily Vancamp' ),
    ( NEWID(), 'Lie to me', 'Gillian Foster', 'Kelli Williams' ),
	( NEWID(), 'Arrow', 'Oliver Queen', 'Stephen Amell' ),
	( NEWID(), 'Scandal', 'Olivia Pope', 'Kerry Washington' ),
	( NEWID(), 'Forever', 'Dr. Henry Morgan', 'Ioan Gruffudd' );

SELECT * FROM show_character_actor_names ORDER BY show_name;