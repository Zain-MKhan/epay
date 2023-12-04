# SOEN387
Assignments for SOEN387 Fall 2023

Zain Khan

Ashiqur Rahman

## Development Environment and Compilation Instructions

For this specific assignment, we are using Maven in VS Code with the Java extensions, as well as the Community Server extension for Tomcat.

In addition, for a3 we are using SQLite for handling the backend.

### To run the tests, you'll need to:
run the following command:
- mvn clean install
  
The test results will be outputted automatically in the Terminal.
The written unit tests may be found in src/test/java

### To run the project, you'll need to:

1. Add Tomcat as a server and start it from the "Servers" tab in VS Code on the left side.
2. Right-click on it to add deployment, which is the WAR file called theprj.war.
3. Go to localhost:8080, and select the "theprj" application, which will bring you to the home index.
4. Go to epay/soen387/epay.db and download this file locally on your machine. Keep note of the location of this file
5. Go to epay/src/main/java/dbConnection.java and update the 'connection' path to the path chosen in step 4

For staff users, login credentials have been defaulted to:
- Username: staff
- Password: secret

For customers, a test login credential:
- Username: user@gmail.com
- Password: secret

If recurring errors occur, please run the following command to clean and install the project:
```bash
mvn clean install
