import java.util.*; // for using Arrays instead of lists 
public class java_42207_CredentialValidator_A08 {     
     static HashMap<String , String> credentials = new HashMap<>();// sample credential list (in real world scenario you would have stored data from database)            
       public static void main(String[] args){  
           //Sample Data   
          addCredentials("alice", "data123");        
          addCredentials("bob" ,  "password1234567890ABCDEFG");    
                    
            try {     
                System.out.println(validateUser("AlICE ",    // false   username case-sensitive (should be all lowercase)          
                                              "data12"  ));         //false password too short       
                 } catch (Exception e){         
                   System.err.printf("%s %s\n",e,Arrays.toString(e.getStackTrace()));    
                };                     
                    
            try {     
               printCredentials();                      
             }catch (IllegalStateException isEx)  //handle case where state doesn't allow serialization      
              {    System.out.printf("Error: %s\n",isEx);          
                 }, Arrays::toString;                    };                     });