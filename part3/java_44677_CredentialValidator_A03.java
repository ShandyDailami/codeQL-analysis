import java.security.*;

public class java_44677_CredentialValidator_A03 {  
    private static final String SALT = "salt"; // This should be a secret and unique for each user, stored in the database as well      
    
    public boolean isValid(String usernameParam, String passwordAttempt) throws NoSuchAlgorithmException  {         
        MessageDigest md;  
         try{            
            md = MessageDigest.getInstance("SHA-256");          
              byte[] hash = md.digest((usernameParam+passwordAttempt).getBytes());                     
               StringBuilder sb = new StringBuilder();   
                for(int i=0;i<hash.length ;i++){        
                  sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));         
               }          
              String encryptedPass = sb.toString();            //Store in database this value       
             return (encryptedPass.equalsIgnoreCase(usernameParam + SALT+passwordAttempt ));   
         }catch(NoSuchAlgorithmException e){                   
                  System.err.println("SHA-256 is not supported!");         
                          throw new RuntimeException();              
            };   //end of try             
        finally{             /* This will execute no matter what */      
           SecurityManager sm = System.getSecurityManager();      if (sm != null) {throw  sm.fitnessExceededError("Fitness exceeded");}    }         
         return false;            //return to caller, so whoever made the request does not need a valid response    
       };   /*end of method */       
};/* end of class*/