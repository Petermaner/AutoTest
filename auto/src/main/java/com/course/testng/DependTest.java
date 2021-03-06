package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test(dependsOnMethods = {"test2"})
    public void test1(){
        System.out.println("test1 run");
    }
    @Test
    public void test2(){
        System.out.println("test2 run");
        throw new RuntimeException();
    }
}
