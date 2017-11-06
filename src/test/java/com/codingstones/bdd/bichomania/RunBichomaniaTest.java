package com.codingstones.bdd.bichomania;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    format = { "pretty", "html:target/features" },
    features = "classpath:features/bichomania"
)

public class RunBichomaniaTest {
}
