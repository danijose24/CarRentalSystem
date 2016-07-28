package com.i2i.controller;

import com.i2i.service.MakeService;
import com.i2i.exception.UserDefinedException;
class TestRun {
    public static void main(String args[]) {
        String id = "HondaCity056";
        String name = "HODAI";
        int rate = 2000;
        try {
            MakeService makeService = new MakeService();
            makeService.addMake(id,name,rate);
            System.out.println("Added Successfully");
       } catch (UserDefinedException e) {
           System.out.println(e);
       }
     }
 } 
