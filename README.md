# jpadb
### Java Persistence API database connectivity demo

"Skeleton" project for JPA-oriented database project 

It creates a WAR package (web project) and demonstraes main CRUD operations, implemented in separate EJBs (Enterprice Java Beans), using container managed transactions mechanism

1. Create database table, using `jpadb\src\main\resources\demodata.sql` script (this script supposed to be executed against PostgreSQL database)

2. We'll use WildFly application server for this sample, so update your 
```xml
<subsystem xmlns="urn:jboss:domain:datasources:4.0"> 
```
section and create new datasource like this:
```xml
<datasource jta="true" jndi-name="java:/wfdatasorce1" pool-name="wfdatasorce1" enabled="true" use-ccm="true">
    <connection-url>jdbc:postgresql://localhost:5432/database</connection-url>
    <driver-class>org.postgresql.Driver</driver-class>
    <driver>postgresql</driver>
    <security>
        <user-name>login</user-name>
        <password>pass</password>
    </security>
    <validation>
        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker"/>
        <background-validation>true</background-validation>
        <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter"/>
    </validation>
</datasource>
```

3. Build project: `mvn clean package`

4. Deploy to J2EE compliant application server (e.g. WildFly) your resulting: `jpadb\target\jpadb.war`

5. After application successfully deployed, demo CRUD operations should be available at the following URLs: 
* http://localhost:8080/jpadb/create (create new records)
* http://localhost:8080/jpadb/read (list saved records)
* http://localhost:8080/jpadb/update (edit existing record)
* http://localhost:8080/jpadb/delete (delete some records)
* http://localhost:8080/jpadb/createrollback (Java Transaction API, JTA demo, how application server manages your transactions) 
