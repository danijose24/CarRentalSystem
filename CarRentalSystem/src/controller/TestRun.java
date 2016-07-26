package controller;
import service.MakeService;
import exception.UserDefinedException;
class TestRun {
    public static void main(String args[]) {
        String id = "HondaCity02";
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
