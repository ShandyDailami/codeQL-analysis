import java.util.*;   // For LinkedHashMap and Collection classes only   
                      // Including all utility packages such as List, Set..etc are not allowed in this code block 
                      
public class java_46566_CredentialValidator_A01 {      
     public static boolean validate(String username , String password){         
            Map<String,String> correctCredentials=new HashMap<>();            
           // Populating the credentials map with hardcoded values for simplicity.                  
            correctCredentials.put("user1","pass1");                          
            correctCredentials.put("user2","pass2");                           
                      
          /* If you have to use Spring or any other framework, make sure they are not used in this solution */  
            
           if(correctCredentials.containsKey(username) &&  // Checking whether the user exists                     
               correctCredentials.get(username).equals(password)){    // checking password against saved hash values      
                  return true;                           
            }else{                        
                System.out.println("Invalid Credential");   // If credentials do not match, print a message and exit the program    
            	return false ;                       
        	} 		       	                			   				                                                  					                                                                                                       	       								         	   	 ​              .;                             };                            }      );                      });                         return true;}                    else{return validate(username , password);}}}   // Calling recursion to check for correct credentials. This is incorrect as per the problem statement so commented out