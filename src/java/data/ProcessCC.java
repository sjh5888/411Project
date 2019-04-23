package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elgoo
 */
import sockets.ServerSockets;
import java.net.*;
import java.io.*;
import java.lang.*; 
import java.util.*; 


public class ProcessCC {
   private String convert;
   private String result;
   private String t="";
   private String p;
   private int c;
   private int n;
public ProcessCC (){
   
}
/*
* Method takes a credit card number as a string and reverses the order
* then multiplies every other number by 2, adds all of the single digits
* together and then attempts to divide by 10. If it divides then credit
* card number passes the check, if not the credit card number fails.
*/
public String process(Socket socket, String id){
     System.out.println("id: " + id);
      // Reverse the credit card string
      StringBuilder input1 = new StringBuilder();
      input1.append(id); 
      input1 = input1.reverse(); 
      result = String.valueOf(input1);
      String r = result;
      
     // Double every other number
     for (int i=0; i<r.length(); i++) {
        c = Character.getNumericValue(r.charAt(i));
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
     
  //Add up all the single digits in this string.
  int n = 0;
  for (int i=0; i < t.length(); i++) {
    c = Character.getNumericValue(t.charAt(i));
    n = n + c;
  }
  System.out.println("n: " + n);
  
    // Check if the result is divisible by ten with no remainder
    if (n != 0 && n % 10 == 0) {
        result = "true";
      }
    else {
        result = "false";
      }
      
      ServerSockets ss = new ServerSockets(11001,5);
      try {
      ss.writeToSocket(socket, result);
      }
      catch (Exception e) {
          e.printStackTrace(System.out);
      }
            return result;

}
}
