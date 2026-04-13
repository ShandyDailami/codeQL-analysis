public class java_46332_CredentialValidator_A07 {    
    public boolean authenticate(String username, String password) throws Exception{        
        // Step #1: Validating input credentials...      
          if (username == null || password==null){            
            throw new IllegalArgumentException("Invalid Credentials");          
          }  else {             
               System.out.println("\nPerforming Authentication...");     
               
                 /* Using a hard-coded example of MD5 for simplicity, in reality you'd use an actual encryption method */   
                  String hashedPassword = "MD5_of_" + password;      
                   if (hashedPassword.equals("expectedHash")){             
                     System.out.println("\nAuthentication Successful!");       
                      return true;}         else {            
                       throw new Exception ("Invalid Credentials");      }  }}