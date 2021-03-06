package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("This is group:server test111");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("This is group:server test222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("This is group:client test333");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("This is group:client test444");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("beforeGroups On Server");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("afterGroups On Server");
    }
}
