public class java_51784_CredentialValidator_A01 {  
    public static boolean validate(String username, String password) throws Exception{      
        // In a real-world scenario these credentials would be retrieved from somewhere.     
         if (!isValidUserNameAndPassword(username,password))  throw new IllegalArgumentException("Invalid Credential");         
           return true;            
     }    public static boolean isValidUserNameAndPassword (String username , String password){       //Simulating real-world access control logic.     
         if ("admin".equalsIgnoreCase(username) && "password1234567890".equals(password)) return true;          else  {           throw new Exception("Access Denied");             }        }}