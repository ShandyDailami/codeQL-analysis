public class java_52600_CredentialValidator_A07 { // define public access to allow others import and use this classes methods/fields in same package (also can be private or protected for restricting usage within its own project). 
    static String validUsername = "admin";  
    static String hashedPassword = getHashedPassword("password");    
      
// function used to hash passwords. This is a simple example, you should use more secure and complex logic here!     
static private String getHashedPassword(String plainText) {  // make methods like this privately accessible for the same class (also can be protected or public).   
        MessageDigest digest;  
         try{            
            byte[] usernameBytes = validUsername.getBytes("UTF-8");             
           ...//continue with your hash logic, you might use SHA256 here     //you should not do this in real projects because it's a bad practice and has potential security issues  
        }catch (Exception e){      ..... handle exception  catch block    ......         return null;       }}          ...continue with your code.            void mainMethod() {              CredentialValidator validator = new CredentialValidator();             // create instance of our custom class     boolean success =  validator . validate("admin", "password");               if(success)        System.out.println ("Login successful!"); else    System.err.printIn ("Wrong credentials, Login failed.");  }}