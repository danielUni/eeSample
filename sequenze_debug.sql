GRANT USAGE ON SCHEMA public to tester;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO tester;

-- repeat code below for each database:

GRANT CONNECT ON DATABASE eeSample to tester;

GRANT USAGE ON SCHEMA public to tester; 
GRANT SELECT ON ALL SEQUENCES IN SCHEMA public TO tester;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO tester;