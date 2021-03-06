-- Table: visitor

DROP TABLE Beverage;
DROP TABLE incentive;
DROP TABLE manufacturer;

CREATE TABLE beverage
(
  id integer NOT NULL,
  version integer,
  name varchar(147),
  manufacture_id integer,
  incentive_id integer,
  price integer,
  quantity integer,
  location varchar(4711)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE incentive
(
  id integer NOT NULL,
  version integer,
  name varchar(147),
  dtype varchar(147)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE manufacturer
(
  id integer NOT NULL,
  version integer,
  name varchar(147),
  dtype varchar(147)
)
WITH (
  OIDS=FALSE
);



ALTER TABLE visitor
  OWNER TO tester;
  

 --create seq_gen_sequence

 DROP SEQUENCE seq_gen_sequence;
 
 CREATE SEQUENCE seq_gen_sequence
 	INCREMENT 50
 	MINVALUE 1
 	MAXVALUE 9223372036854775807
 	Start 800
 	CACHE 1;
 
 ALTER TABLE seq_gen_sequence
 OWNER TO tester;
  
  
 -- user rights  

GRANT USAGE ON SCHEMA public to tester;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO tester;

-- repeat this code below for each database:

GRANT CONNECT ON DATABASE eeSample to tester;

GRANT USAGE ON SCHEMA public to tester; 
GRANT SELECT ON ALL SEQUENCES IN SCHEMA public TO tester;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO tester;