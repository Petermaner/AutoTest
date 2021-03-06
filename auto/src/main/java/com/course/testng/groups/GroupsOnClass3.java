package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("GroupsOnClass1 teacher1 success");
    }
    public void teacher2(){
        System.out.println("GroupsOnClass1 teacher2 success");
    }
}
