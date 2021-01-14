package com.tajawal.api.config;

import com.tajawal.api.utility.PropertiesUtility;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
//import org.junit.Before;

import java.util.Properties;

public class Hooks {
    public static Scenario hooksScenario;
    public static Properties applicationProperties;


    @Before
    public void preSteps(Scenario scenario) {
        this.hooksScenario = scenario;
        this.applicationProperties = PropertiesUtility.loadPropertyFile("/application.properties");
    }



}
