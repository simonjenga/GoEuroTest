Java Developer Test Solution
============================

This is a Java command line tool that takes as an input parameter a string and queries an API query and transform the result data into a CSV file

```
java -jar GoEuroTest.jar "CITY_NAME"
```

The program takes this string and queries with it our Location JSON API endpoint:

http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME

Where CITY_NAME is the string that the user has entered as a parameter when calling the tool, e.g.

http://api.goeuro.com/api/v2/position/suggest/en/Berlin

Building The Project
====================

The project uses ```Java 7``` and ```Maven 3``` as the build tool and also to manage the dependencies.

To run Maven build execute the following command from a console/command prompt with the project root directory as the top level directory:

```
mvn clean package
```

This will create a distributable and executable JAR file for the standalone application.

Then run the JAR file created by executing the following:

```
java -jar target/GoEuroTest.jar Melbourne
```

To execute Unit tests, execute the following:

```
mvn clean test
```