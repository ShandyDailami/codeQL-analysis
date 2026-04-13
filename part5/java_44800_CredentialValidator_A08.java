public class java_44800_CredentialValidator_A08 {
    public static void main(String[] args) throws Exception{  
        // Define a username and password for the credential validator. For this example, I'll use 'user123'. Please replace with actual user credentials in real applications! 
         String expectedUsername = "admin";      
         char[] expectedPassword  = {'p', 'w', 'e', 'r", ''t''};    // Note: This is a simple encryption of password, you should use appropriate methods and libraries for your production code.  
         
        CredentialValidator validator =  new MyCredentialsValidation(); 
         if(validator.validate("admin","password")){            
            System.out.println("Access granted!");             
         } else {                   
           // Access denied, handle exception here or use appropriate fallbacks in production code  
          throw new Exception ("Invalid username/ password combination"); 
        };   
     }      
}