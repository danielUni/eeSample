eeSample
========

Ant Build
---------

0. Check settings in "ant.properties"
	
1. Setup Postgres Database driver	
	-copy res/ear/lib/postgresql
		-target directory: [Glassfish directory]/glassfish/domains/[domain dir]/lib/ext
		
2. Setup of Postgres Database
	-create new login role
		-Name: tester
		-Psw: tester
		
	-add new database
		-Name: 	eesample
		-owner: tester
		-Execute: "db_tables.sql"
		
3. Ant 
	-Run targets: Start-Glassfish, int, compileEJB, createEJBjar, compileWeb, build-war, createEar, deploy
	!!!Order Matters!!!
	
4. Open the Web interface, start the application and have fun!!!! ;-)	
		