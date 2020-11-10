# dbconsample
After checkout this project, following operations are required before develop this project.
1. Install postgresql database on your computer.
2. Create database named "sample" from pgAdmin or psql.  
From psql, start cmd or powershell and execute following commands.
~~~
    $> [POSTGRESQL_HOME]\bin\psql.exe -U [database administrator password]
    #> CREATE DATABASE sample;
~~~
3. Create table named "users" in "sample" database from pgAdmin or psql.  
From psql, start cmd or powershell and execute following commands.
~~~
    $> [POSTGRESQL_HOME]\bin\psql.exe -U [database administrator password] -d sample
    #> CREATE TABLE users
       (
         userid serial PRIMARY KEY,
         username VARCHAR(64),
         birthday DATE
       );
~~~
4. Resolve java libraries at java IDE (Eclipse).
5. Edit context by following operations at java IDE (Eclipse).
   - Open Properties for this project.
   - Open "Tomcat" view.
   - Edit "other information" to following text. (Expressed by "[]" are depend on environment.)
~~~
       <Resource driverClassName="org.postgresql.Driver"
            initialSize="1"
            maxIdle="1"
            maxWaitMillis="-1"
            name="jdbc/sample"
            type="javax.sql.DataSource"
            url="jdbc:postgresql://localhost:5432/sample"
            username="[postgres administrator user name]"
            password="[postgres administrator user password]"
            defaultAutoCommit="false"
       />
~~~
After operations above are all done, please examine running.
