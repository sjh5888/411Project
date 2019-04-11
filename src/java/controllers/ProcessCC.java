
package controllers;
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

public String process(String id){

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
    
