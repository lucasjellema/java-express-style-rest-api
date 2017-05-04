# java-express-style-rest-api
This repository contains a simple, straightforward example of a Java (Oracle JDK) based REST API implemented very much like Node Express style REST APIs.

The steps taken to create this repository:

* create scaffold using Maven (compare npm init)

mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=nl.amis.rest -DartifactId=my-rest

* edit Maven's pom.xml to add dependencies (compare package.json and npm install --save)

Note: also add build section in pom.xml with explicit indication of Java 1.8 as source and target version (to ensure Lambda expressions are supported)


* retrieve required libraries using Maven (compare npm install)
    mvn install dependency:copy-dependencies

* edit Java class - use imports for required dependencies (compare require instructions in node application)
class App.java contains the most simple and straightforward http request serving application conceivable

class App2.java builds on App2 to add the REST API capabilities 

* build application using Maven (this step does not really exist for node applications; programming errors come out at run time )

mvn package


* run application which starts the REST API at http://localhost:8765
java -cp target/my-rest-1.0-SNAPSHOT.jar;target/dependency/* nl.amis.rest.App

(or use run-app for short)