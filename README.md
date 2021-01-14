# apiAutomation
This repo is for tajawal code chalenge

# Pre-requirements:
JAVA, Maven, Alure needs to be installed in system.

1) Test scenarios are present in *.Feature file under src/main/resources/features folder. 
2) Step and service files are present under src/test/java/com.tajawal.api.steps package. 
3) Test runner files are present under the package src/test/java/com.tajawal.runner.regression package. 
4) To run the test cases, use the below maven command
5) To run specific runner package,
    mvn -B -f pom.xml test -Dtest.tagnames=regression
6) To run all test cases
    mvn test
    
7)Test Reports will auto generated under the allure-results 
 **Note:**
The report will be displayed in the browser, if not plz go the project location and execute the below command "allure serve" 


Sample run report image is under sampleReportImage folder