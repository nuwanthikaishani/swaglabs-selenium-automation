package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
//    private static ExtentReports extent;
//
//    public static ExtentReports getInstance() {
//        if (extent == null) {
//            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
//            extent = new ExtentReports();
//            extent.attachReporter(htmlReporter);
//        }
//        return extent;
//    }

    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent == null){
            ExtentReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter((ExtentObserver) htmlReporter);

        }
        return  extent;
    }
}
