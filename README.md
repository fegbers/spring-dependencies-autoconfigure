# spring-dependencies-autoconfigure

Spring auto configuration for the dependencies-maven-plugin and adds the information to the actuator-info endpoint.

Dependency:
```
<dependency>
	<groupId>de.fegbers.spring</groupId>
	<artifactId>spring-dependencies-autoconfigure</artifactId>
	<version>0.1.0-RC</version>
</dependency>
```


An example actuator-info output:

``` json
{
  "dependencies" : {
    "org_springframework_boot_spring-boot-starter-web_jar" : "2.0.4.RELEASE",
    "org_projectlombok_lombok_jar" : "1.16.22",
    "org_easymock_easymock_jar" : "3.5.1",
    "org_assertj_assertj-core_jar" : "3.9.1",
    "org_powermock_powermock-api-easymock_jar" : "1.7.3",
    "org_springframework_boot_spring-boot-starter-actuator_jar" : "2.0.4.RELEASE",
    "com_spotify_docker-client_jar" : "8.9.0",
    "org_apache_commons_commons-lang3_jar" : "3.7",
    "org_glassfish_jersey_inject_jersey-hk2_jar" : "2.26",
    "pl_project13_maven_git-commit-id-plugin_jar" : "2.2.4",
    "org_powermock_powermock-module-junit4_jar" : "1.7.3",
    "junit_junit_jar" : "4.12"
  }
}
```
