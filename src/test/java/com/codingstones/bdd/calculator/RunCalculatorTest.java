package com.codingstones.bdd.calculator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/calculator/features" },
        features = "classpath:features/calculator/calculator.feature"
)
public class RunCalculatorTest {
}