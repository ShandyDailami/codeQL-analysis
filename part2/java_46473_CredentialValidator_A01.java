public class java_46473_CredentialValidator_A01 {    // this is just a placeholder, you should replace it with your own authentication system's data source  
     public static final String USERNAME = "admin";     
     public static final String PASSWORD =  "password1234567890!"; 
}
public class CredentialValidator {    // this is just a placeholder, you should replace it with your own authentication system's data source  
       private boolean validate(String username, String password)     {         return (username.equalsIgnoreCase("admin") &&        password.equals("password1234567890!"));      }    public  Boolean isValidCredential(String userName , String passWord){          if(!validate(userName,passWord))
   {             System.out.println ("Invalid Credentials");           return false;         }} else{              //System should print the login successful message here                Console.WriteLine("Login Successful!");        }    public static void main (String args[] )          new     LoginForm().setVisible(true );
}