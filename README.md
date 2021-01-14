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
7)Test Reports will get generate under the allure-results


Sample run report image is under sampleReportImage folder