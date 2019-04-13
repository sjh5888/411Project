/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elgoo
 */
import java.net.*;
import java.io.*;
import java.lang.*; 
import java.util.*; 


public class ProcessCC {
   private String convert;
   private String result;
   private String t;
   private String p;
   private int c;
   private int n;
public ProcessCC (){
   
}

public String process(Socket socket, String id){
    
      StringBuilder input1 = new StringBuilder();
      input1.append(id); 
      input1 = input1.reverse(); 
      result = String.valueOf(input1);
      String r = result;
     t = "";
     for (int i=0; i<r.length(); i++) {
        char k = r.charAt(i);
        c = Character.getNumericValue(k);
        if (i % 2 != 0) {
          c = c*2;
          t = t + c;
        }
        else {
        p = String.valueOf(r.charAt(i));
        t = t + p;
        }
        }
     System.out.println("t: " + t);
  // Finally, add up all the single digits in this string.

  int n = 0;
  for (int i=0; i < t.length(); i++) {
    c = Character.getNumericValue(t.charAt(i));
    n = n + c;
  }
  System.out.println("n: " + n);
      if (n != 0 && n % 10 == 0) {
    result = "true";
      }
      else {
    result = "false";
      }
      
      ServerSockets ss = new ServerSockets(10001,5);
      try {
      ss.writeToSocket(socket, result);
      }
      catch (Exception e) {
          e.printStackTrace(System.out);
      }
            return result;

}
}