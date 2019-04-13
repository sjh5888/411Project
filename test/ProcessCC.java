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

public class ProcessCC {
   private String convert;
   private int i;
   //private boolean result;
   private String result;
public ProcessCC (){
   
}

public String process(Socket socket, String id){
    
        convert = id;
        String[] checkArray = convert.split("");
        System.out.println(checkArray.length);
    
        if (checkArray.length == 16){
            result = "true";
        }
        else{
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