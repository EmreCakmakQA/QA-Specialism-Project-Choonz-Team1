# "Choonz" Full Stack Web Application
===================================

This repository contains the full code base for front and back end (including tests), documentation, installation instructions, and special acknowledgments. The application contains 6 entities: Tracks, Artists, Albums, Playlists, Genres, and Users. The back end supports CRUD functionality for all 6 entities. The front end allows a user to browse the contents of the database and also allows a user to login and create their own playlists. Future developments have been outlined in the provided presentation within the Documentation folder.

## Specifications
--------------

See specification document under Documentation folder...

## Installations

-   Jmeter Installation

-   Check you have Java installed with java -version

-   If the command comes back as unrecognised, you'll need to install/reinstall/repair your Java installation before continuing.

-   Ensure that your JAVA_HOME system environment variable is set to point at your Java installation.

-   Ensure that %JAVA_HOME%\bin is appended to the end of your system Path environment variable.

-   Download the latest version of JMeter from [the Apache website](https://jmeter.apache.org/download_jmeter) and extract it to your Program Files folder.

-   Set up a new environment variable called JMETER_HOME, and append %JMETER_HOME%\bin to your system Path variable.

-   Check to see if everything works by navigating to your JMeter installation's bin folder and clicking jmeter.bat. If successful, the application should run:

-   Springtool Suite:

-   Navigate to [the Spring Tools page](https://spring.io/tools), then click the relevant download for your system:

-   This will download a tar.gz (Linux), .dmg (macOS), or self-extracting .jar (Windows).

-   Extract/Open this file; this should generate a folder containing the installation.

-   Inside this folder (e.g. sts-4.8.1-RELEASE), run the SpringToolSuite4 application:

-   This should open the Spring Tool Suite IDE.

-   Go to File -> Open Projects From File Stream-> Browse your directories to find the Project

-   Vscode:

-   Navigate to <https://code.visualstudio.com/download> to download Vscode.

-   Choose your version depending on your OS

-   Open up your terminal and navigate to src/main/resources/static and type in "code ."

-   Maven:

-   A Java version of 14.0.2 or higher is recommended

-   Maven installation <https://maven.apache.org/install.html>

-   <https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/> The links above contain instructions on how to install maven followed by the download link itself.

-   In order to rebuild the jar files to run, the following commands need to be input into the a cli where your pom.xml file is located. Or running maven through the Springtool Suite.

-   mvn clean

-   mvn install

-   SQL Local Installation:

-   If you don't already have a local version of SQL installed go to the [MySQL Community Download page](https://dev.mysql.com/downloads/mysql/5.7.html) and download MySQL Installer for your operating system. Once finished extract the zip file to C:\Program Files\ on your machine

-   Once it is extracted to C:\Program Files\mysql-5.7.x\ (the x will be different, depending on the version you have), you will need to create a data folder inside it:

-   Open a command prompt and navigate to the installation folder with the following command (replace the x according to your version):

-   cd  mysql-5.7.x

-   Once there, ensure that the data folder you just made is empty, then type the following:

-   mysqld --console --initialize

-   A firewall warning may pop up on your screen. Ensure that both boxes for Private and Public networks are checked, then click Allow Access.

-   That command should have created the entire system for you, including a default super-user called root@localhost. Take note of the temporary password that it generates for this user

-   Check to see whether the initialised server will run, using the following command:

-   mysqld --console

-   You should find that the command prompt will no longer accept input from you - which means the server is running.

-   Open a new command prompt, and this time, log into the server as the super-user:

-   mysql -u root -p

-   You should be greeted with a welcome message, and your console indicator should change to the following:

-   mysql>

-   The server won't let you use MySQL until you reset your password. Enter the following command to reset it:

-   ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';

-   This will reset your super-user password to root.

-   Finally, we'll make MySQL start as a Windows service, so that you don't need to manually activate the server every time you want to use it.

-   Close ALL command prompt windows.

-   Then, open a new command prompt as administrator:

-   cd  C:\mysql-5.7.x\bin

-   Once there, run the following command:

-   mysqld --install

-   Open up Windows Services and look for MySQL in the list:

-   Once there, right-click it and click Start.

-   The status should change to Running:

-   In the Start Menu, search for 'env' and click the option to edit system environment variables:

-   Click Environment Variables. This should open another window:

-   In the bottom System Variables panel of this window, click New, then, in the window which opens, replicate the following setup (replacing x with your version of MySQL):

-   Click OK, then scroll in the bottom panel until you find the Path variable. Select it and click Edit, then add the following:

-   %MYSQL_HOME%\bin

-   These instructions have been graciously provided at QA's community website

## Testing Strategies:

The following test suite has been implemented:

-   Unit Testing of the website back-end

-   Integration Testing of the website back-end

-   User-Acceptance Testing of the website front-end

-   A Non-Functional Testing Suite

-   A Functional Testing Suite

-   Use of a Static Analysis tool

We aimed to reach for the industry-standard of 80% test coverage, having achieved 85.4% of our "src/main/java" folder (above 90% overall).

The testing frameworks implemented are:

-   Junit

-   Mockito

-   Selenium/ Selenium IDE 

-   Jmeter (Performance Testing)

-   Sonarqube (Static analysis)

Our aims for Non-Functional Testing :

-   Response times aim to be <10 ms

-   Latency <2 seconds at 10000 concurrent users

-   Throughput rate > 300s (achieved with a throughput timer)

-   Minimal RAM allocation

-   Load, Spike, Stress, and Soak Tested. (All entities CRUD-ed)

## ERD
---

See documentation folder within this repository for ERD diagrams

## UML
---

See documentation folder within this repository for UML diagrams

## Authors
-------

-   Team 1, Training Team (QA)

### Training Team

-   Client - [Angelica Charry](https://github.com/acharry) - Software Delivery Manager

-   Product Owner - [Nick Johnson](https://github.com/nickrstewarttds) - Initial work (backend & frontend development, specification)

-   Product Owner - [Edward Reynolds](https://github.com/Edrz-96) - Initial work (testing, specification)

-   [Jordan Harrison](https://github.com/JHarry444) - General Java wizardry

-   [Alan Davies](https://github.com/MorickClive)

-   [Savannah Vaithilingham](https://github.com/savannahvaith)

-   [Vinesh Ghela](https://github.com/vineshghela)

-   [Piers Barber](https://github.com/PCMBarber)

### Development Team

-   Sue Bluck

-   Benjamin Simon  - Back-end guru

-   Benjamin Oluyomi

-   Emre Cakmak - Front end sensei

### Acknowledgements
----------------

-   Special mention to Edward Reynolds who provided us with outstanding moral support and guidance

-   Good use was made of google to assist development, debugging and testing

-   Sites that were particularly useful included Baeldung.com, stackoverflow.com and stackexchange.com, in addition to the various tools sites documentation

-   QA Community

TeamChoonzQA-Project-3# QA-Specialism-Project-Choonz-Team1
==========================================================