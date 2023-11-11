# SOEN387
Assignments for SOEN387 Fall 2023

Zain Khan

Ashiqur Rahman

## Development Environment and Compilation Instructions

For this specific assignment, we are using Maven in VS Code with the Java extensions, as well as the Community Server extension for Tomcat.

In addition, for a2 we are using mysql/mysql workbench for handling the backend.

### To run the project, you'll need to:

1. Add Tomcat as a server and start it from the "Servers" tab in VS Code on the left side.
2. Right-click on it to add deployment, which is the WAR file called theprj.war.
3. Go to localhost:8080, and select the "theprj" application, which will bring you to the home index.
4. Have mySQL server and workbench installed and defaulted to localhost port 3306.
5. Download the latest database dump found at https://drive.google.com/drive/folders/1BsTzX80Za7Qq8WV3Abei-du955B-fsro?usp=sharing and import it through mySQL workbench's 'Navigator' by clicking on 'Data Import/Restore'
6. Following step 4, visit src>main>java>connection>dbConnection.java and replace the "dbuser" user name and "dbpass" password with your own username and password for mySQL

For staff users, login credentials have been defaulted to:
- Username: staff
- Password: secret

For customers, a test login credential:
- Username: user@gmail.com
- Password: secret

If recurring errors occur, please run the following command to clean and install the project:
```bash
mvn clean install
