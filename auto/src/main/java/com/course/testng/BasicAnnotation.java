package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("test1");
    }

    @Test
    public void testCase2(){
        System.out.println("test2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("======beforeClass======");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("======afterClass======");
    }


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }

}
