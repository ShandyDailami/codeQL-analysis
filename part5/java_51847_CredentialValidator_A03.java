import com.google.gson.*; // GSON is used for JSON parsing and serialization (not a security-sensitive operation)
    
public class java_51847_CredentialValidator_A03 {  
    public boolean validate(String user, String password){ 
        try{     
            if ("user123".equalsIgnoreCase(user)){ // Assuming the server has hardcoded users and their corresponding passphrases. This is not recommended in a real-world application due to security issues (A05_Inject).  
                return true; 
             } else {   
                  if ("password123".equals(password)){ // Assuming the server has hardcoded passwords and their corresponding usernames. This is not recommended in a real-world application due to security issues (A05_Inject).  
                       return true; 
                   } else {    
                        System.out.println("Invalid username or/and Password provided");    // Printing the error message if credentials are incorrect     
                 	}	            		        			         	 	     	       	   									           							        "});                         ,,,,,");   return false;  }} catch (Exception e){System . out . println ("Invalid input format" +e.getMessage());returnfalse;}     }    // try-catch block end here