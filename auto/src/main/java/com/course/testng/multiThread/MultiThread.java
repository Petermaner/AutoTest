package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThread {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test2(){
        System.out.println("111");
        System.out.printf("Thread ID : %s%n",Thread.currentThread().getId());
    }
}
