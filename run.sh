#mvn clean spring-boot:run -Drun.jvmArguments="-Dspring.config.location=classpath:/application.properties -Dserver.port=9000 -Dspring.profiles.active=dev -Dspring.data.neo4j.uri=bolt://neo4j:dev@localhost-from-COMMAND-LINE"

mvn clean spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=dev -Dspring.config.location=classpath:/application.properties"