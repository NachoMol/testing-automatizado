package com.example.integrador_testing_automatizado.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/REPORTES-REGISTRO.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Selenium Version", "4.9.1");
            extent.setSystemInfo("SO", "Windows 11");
            extent.setSystemInfo("Navegador", "Chrome");
            extent.setSystemInfo("ENV", "QA");
        }
        return extent;
    }
}
