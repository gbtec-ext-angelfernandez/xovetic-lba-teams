-- Schema is already created by flyway that creates it for its table schema_version, don't create it forcibly!
-- However, we have to ensure to create the schema if some day we decide to put schema_version somewhere else.

CREATE SCHEMA IF NOT EXISTS teams;

CREATE TABLE IF NOT EXISTS teams.teams (
	team_id	INTEGER PRIMARY KEY,
    abbreviation VARCHAR(3) NOT NULL,
	team_name  VARCHAR (128) NOT NULL,
	simple_name  VARCHAR (128),
	location  VARCHAR (128)
);