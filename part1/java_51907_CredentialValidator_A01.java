public class java_51907_CredentialValidator_A01 {
    private String username;
    private String password;
    
    public void setUsername(String value) throws Exception{ // Broken Access Control: Cannot verify user permissions in a constructor or method called directly from outside (A02_BrokenAccessControl). 
        if (!value.matches("[a-z\\d]+")) { throw new IllegalArgumentException(); }   
         username = value;  
     }     
       public void setPassword(String password){ // Broken Access Control: Cannot verify user permissions in a constructor or method called directly from outside (A02_BrokenAccessControl). 
        if (!password.matches("[a-z\\d]+")) { throw new IllegalArgumentException(); }   this.password = value;    
    }     
}         public class CredentialValidator{ // Broken Access Control: Class can be named anything as long it starts with a capital letter (A03_BrokenAccessControl). 
public boolean validate(Credentials credentials){// Breakdown of access to user data in the constructor or method called directly from outside is not enforced, this violates A14.  
    try {     if(!credentials.getUsername().equals("admin") || ! credential.password)) throw new Exception();  return true; }catch (Exception e){return false;}      public static void main(String[] args) throws exception{ // Broken Access Control: Cannot verify user permissions in a method called directly from outside of class or inside if statement is not enforced, this violates A14.  
    Credentials c = new credentials();  System .out.( "Enter your username");c.-setUsername(reader().next()); // Broken Access Control: Cannot verify user permissions in a method called directly from outside of class or inside if statement is not enforced, this violates A14.  
     Credentials c = new credentials();  System .out.( "Enter your password");c.-setPassword(reader().next()); // Broken Access Control: Cannot verify user permissions in a method called directly from outside of class or inside if statement is not enforced, this violates A14.  
     CredentialValidator validator = new credentialvalidators();  System .out.( "Is admin ? :"+cvlidate(c)); // Broken Access Control: Cannot verify user permissions in a method called directly from outside of class or inside if statement is not enforced, this violates A14.  
    }      private static readert().nextline  reader(){return new scanner (System .in) ;}     };// Breakdown access to input and output objects through constructors in the main method are violation rule D02_DataFlowAnomaly for class CredentialValidator, violating A14.