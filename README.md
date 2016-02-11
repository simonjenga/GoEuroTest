Restful Web Service Code Challenge
============================

This is a Java command line tool that takes a String as an input parameter, queries an API endpoint and transforms the result data into a CSV file.

```java -jar target/GoEuroTest.jar "CITY_NAME"```

The program takes this String "CITY_NAME" and queries it with the location JSON API endpoint:

http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME

Where CITY_NAME is a String that the user has entered as a parameter when calling the tool, e.g.

http://api.goeuro.com/api/v2/position/suggest/en/Berlin

Building The Project
====================

The project compiles with ```JDK >= 1.5``` and ```Maven >= 3.1.1``` as the build tool and to also manage the project dependencies.

To run Maven build, execute the following from a console/command prompt with the project root directory as the top level directory:

```mvn clean package```

This will create a distributable and executable JAR file for the standalone application.

Then run the JAR file created by executing the following:

```java -jar target/GoEuroTest.jar Melbourne```

Results of the API query will be saved in a CSV file called: ```GoEuroTest.csv``` created at the root directory of the project.

To run Unit tests, execute the following:

```mvn clean test```

### Instructions

Eclipse users run `mvn eclipse:eclipse` and then import the project or just import the code as a Maven project into IntelliJ, NetBeans, or Eclipse.

To generate project documentation of Java source files (Javadoc), run `mvn javadoc:javadoc`
