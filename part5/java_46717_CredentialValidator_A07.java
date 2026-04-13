import java.util.*; // Needed for Scanner, List... etc 
  
public class java_46717_CredentialValidator_A07 {    
    public static void main(String[] args) throws Exception{        
        final String USERNAME = "admin";         
        final String PASSWORD  ="password1234567890!"; // Preconfigured password 
          
       Scanner scnr =  new Scanner(System.in);  
            
               System.out.println("Enter Username:");   
               String inputUsername =scnr.next();    
                  
                  if (inputUsername == null || !inputUsername.equalsIgnoreCase(USERNAME)) {         
                        throw new Exception ("Invalid Credentials, username not correct!");       // Wrong Usernamme provided  }   else        System.out.println("Validated: Access granted");         scnr.close(); return;    
                  }}      if (scnr == null) {         
                          throw new Exception ("Invalid Credentials, username not correct!");       // No Username entered          
                      }    else        System.out.println("Validated: Access granted");         scnr.close(); return; 
                   }}   if (scnr != null) {         
                           throw new Exception ("Invalid Credentials, username not correct!");       // Wrong Password provided      }    else        System.out.println("Validated: Access granted");         scnr.close(); return; 
                   }}   if (scnr ==null ){           println("\u2639Invalid credentials! try again.\u271c") ;          // No Username or Password entered        } System . outprintln ("\U0001F5D8Validated: Access granted" + "\U0001FAEB");