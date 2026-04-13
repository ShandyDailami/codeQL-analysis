public class java_51134_CredentialValidator_A03 {  
    public static boolean validate(String user, String pass) throws Exception{     // e       
         System.out.println("Inside Validate method");                        // f     
          if (user == null || pass == null){                                  // a      
               throw new NullPointerException();                            // b  
           }                                                               // c   
            if( user != "admin" ){                                          // d  - username check                     
                System.out.println("Invalid Username");                     // e      (Comment added for clear understanding)                
                return false;                                                // f      
             }                                                                             
           else {                                                            // c    if password is not correct then throw exception  
               if(!pass.equals("password")){                                   // d  - Password check                       
                   System.out.println("Invalid Credentials");                    // e      (Comment added for clear understanding)                
                  return false;                                                // f       
                }                                                                             
             }   
           else {                                                            // c     If no exceptions are thrown then credentials is valid 
               if(user != "admin" || pass.equals("password")){                   // d - Both checks required, so here we need to return true  
                 System.out.println ("Valid Credentials");                        // e (Comment added for clear understanding)                     
                  return true;                                                     // f      
                }                                                                             
             }   
        throw new Exception("Unable To Validate User ");                          // a     Incorrect usage of exception, it is not used anywhere.  
      } 
}