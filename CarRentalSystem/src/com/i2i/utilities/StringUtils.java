package com.i2i.utilities;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class StringUtils {
	public static void appendToFile(Exception e , String message) {
       FileWriter fileWriter;
        BufferedWriter buffWriter = null;
        PrintWriter pWriter = null;
        try {
            Date date = new Date() ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            fileWriter = new FileWriter("com/i2i/log/"+dateFormat.format(date) + ".txt", true);             
            buffWriter = new BufferedWriter(fileWriter);
            fileWriter.append(message+"\n");              
            pWriter = new PrintWriter(buffWriter, true);
            e.printStackTrace(pWriter);
        } catch (Exception ie) {
            throw new RuntimeException("Could not write Exception to File", ie);
        } finally {       
            try {    
                buffWriter.close();
                pWriter.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
}

