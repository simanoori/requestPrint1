package com.spring.myapplication.properties;

/**
 * Created by Hi on 6/18/2022.
 */
public class ApplicationType {
    public static String  applicationType = "myApplication";

    public static String getApplicationType() {
        return applicationType;
    }

    public static void setApplicationType(String applicationType) {
        ApplicationType.applicationType = applicationType;
    }
}
