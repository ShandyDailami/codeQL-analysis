public class java_50427_CredentialValidator_A08 {  
    public static void main(String[] args)  {    
        try{          
            validate("wrong");      //this will throw exception as "Admin" is not correct              
       }catch (CredentialsIncorrectException e){         System.out.println ("Error: Invalid username or password.");}         
    class CredentialValidator {   public static void main(String[] args)  {}        String expectedUser="admin";     int attemptsAllowed = 3;      if (!validate("Admin",attemptsAllowed)) throw new SecurityException();           System.out.println ("Login Successful!");    }      
}             private boolean validate (final Object user){            return ((user instanceof  String ) && expectedUser .equals(user));     }}   CredentialsIncorrectException extends Exception { public java_50427_CredentialValidator_A08() {}          protected java_50427_CredentialValidator_A08(String message)      {         super (message);}}