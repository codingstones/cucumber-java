package com.codingstones.bdd.vat;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/vat/features" },
        features = "classpath:features/vat"
)
public class RunVATTest {
}