package com.sa.gps.tracker.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", format = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})   
public class RunCucumberTest {
}
