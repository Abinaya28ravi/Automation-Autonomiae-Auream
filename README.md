Autonomiae Auream Automation Pack 

Autonomiae Amittit Auream (or TripleA) is a web studio that offers automation testing services. 

This Automation pack/suite is intended to perform functional and exploratory testing on the ‘Autonomiae Auream’ site. 


Description 

This project is mainly used to run automation test for 

End to end application flow 

Validation test cases for webpage fields, styling inconsistencies of web elements, image loading and persistence layer checks.  

 

Getting Started 

Dependencies 

The local system/server intended to run the test should have below tools/software/files installed in it 

IntelliJ IDE 

OS: Mac or Windows 

Java (Java 1.8) 

Web drivers for respective web browsers 

Autonomiae Auream application bundle 

 

Installation guide 

IntelliJ IDE - Community version - bundled with gradle and maven  

https://www.jetbrains.com/idea/download/ 

NB: IntelliJ is preferred for gradle project  

Download the “Autonomiae Auream application” from this page and save it in local. Note down the file location path which needs to be used in the code which is mentioned in upcoming session in the document. 

Pull Automation pack from git hub or download into the local and then import the project into IntelliJ tool. Steps defined in Execution session 

For webdriver , Google the drivers for respective OS and browser version-> Download it and save it in respective folder structure mentioned in Project Structure session.  

       Example: for chrome driver check the link - https://chromedriver.chromium.org/downloads 

 

Tools, framework and plugins used 

Build automation tool: Gradle  

Open source reporting library: Serenity BDD 

Framework: BDD using Cucumber and Page Object Model 

Automation testing framework tool: Selenium  

Language: Java, JavaScript 

 

 Project Structure 
src/test/java —> Main package: com.automation.AutonomiaeAuream  

      —>package: pages - contains individual page objects such as home page etc.-POM 

          		      —> package: stepdefinitions - contains all step definition referred by feature files 

          		      —> package: utilities - contains common configuration classes, utils and runner class 

     	            —> Folder: resources 

                               —> Folder: features - contains cucumber feature files covering all test scenarios 

                                      —> E2E scenarios - End to end automation test feature definition  

                                      —> Webpage validation scenarios - validates field in the pages 

                         —> JSON: Contains JSON file used in the web application 

                         —> web driver: contains web drivers 

target 

     —> site/serenity- contains serenity test reports   

 build.gradle —> contains configurations such as dependencies, plugins, properties, adhoc tasks etc. required for gradle and serenity. 

 Serenity.conf —> contains properties required for serenity BDD such as headless, WD location etc. 

 

Executing Test Suite 
Pre-requisites: 

Ensure Web application -Autonomiae Auream is available in the local/remote system where test suite is intended to run 

Download respective web drivers matching the browser version under test.  

Download test automation project from provided GITHUB link  

Steps: 
IntelliJ: File >> Open >> Select automation project (only if project downloaded to local, else please pull the project from GITHUB) 

When prompts, click on ‘import gradle’  

Go to web driver folder and place the appropriate driver in correct OS folder.  

       Note: follow naming and folder path as mentioned in serenity.conf file (driver section) 

Go to com.automation.AutonomiaeAuream.utilities ->CommonConfig class, update URL in line 13 (as per the URL in system under test)  

e.g. file:///Users/abinaya.ravi/Downloads/Automation_Handout_Bundle/index.html 

Click on ‘gradle’ option on top right- side panel >> tasks >> build >> run all tasks under build  

Check whether all external dependencies are listed in ‘external libraries’ 

Go to Run > Edit configuration > click ‘+’ select gradle >  

       Project: /Users/abinaya.ravi/Downloads/Automation-Autonomiae-Auream

       Task: clean test aggregate 

       Arguments: --info -Dwebdriver.driver=chrome  -Dcucumber.options=‘--tags @E2Ehappypath’       

Note: update driver and tags based on test scenario and browser under test              			
@E2Ehappypath —> tag for happy path scenario  
@Validations       —> tag for validations in each page  
In addition, there are specific tags which can be referred in feature file for respective scenarios.  

Click apply >> Ok 

Click on run symbol in top right toolbar.  

Test execution will begin and produce results accordingly 




Reporting :
Once test execution is completed, serenity reports can be viewed in below location  
target >> site >>Serenity >> index.html>> open in browser 
Click on each link to see details 

 

 

 
