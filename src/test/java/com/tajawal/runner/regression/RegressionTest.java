package com.tajawal.runner.regression;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.tajawal"},
        features = "src/main/resources/features",
        monochrome = true,
        tags = "@Regression",
        plugin = {"pretty", "html:target/cucumber-html-reports", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "json:target/cucumber-html-reports/cucumber.json", "rerun:target/failed_scenarios.txt"}


)
public class RegressionTest {

    @AfterClass
    public static void generateReport() throws IOException, InterruptedException {
        String[] cmd = {"allure", "serve",System.getProperty("user.dir")+"/allure-results"};
        Runtime.getRuntime().exec(cmd);
    }

}
