package com.petroandrushchak.tests.signin;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]
                {
                        {"data one", "data one additional"},
                        {"data two", "data two additional"}
                };
    }

    @Test(dataProvider = "data-provider")
    public void testMethod(String data, String additionalData) {
        System.out.println("Data is: " + data + " Additional data: " + additionalData);
    }
}


