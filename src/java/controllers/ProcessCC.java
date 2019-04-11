/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elgoo
 */
public class ProcessCC {
   private String convert;
   
   private int i;
   private String result;
    
public ProcessCC (){
   
}

public String process(long id){
    
        convert = Long.toString(id);
        String[] checkArray = convert.split("");
        System.out.println(checkArray.length);
    
        if (checkArray.length == 16){
            result = "true";
        }
        else{
            result = "false";
        }
        

      return result;
}
}
    
