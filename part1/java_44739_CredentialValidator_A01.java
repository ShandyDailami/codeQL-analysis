public class java_44739_CredentialValidator_A01 {    
    public static boolean validate(String username, String password) {        
        // Hard-coded user and pass details for testing purposes only           
        if (username == null || !username.equals("user")) return false;                
        else if (password == null  || !password.equals("pwd") )return false;              
                  
       return true;     }    //end of validate method     
   public static void main(String[] args) {        
           System.out.println(validate("user", "pwd"));          }}  --> end here