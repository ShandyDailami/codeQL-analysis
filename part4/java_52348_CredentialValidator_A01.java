import java.security.*;
class java_52348_CredentialValidator_A01 {  
    private String username;       //username field    
                                                           
    public void setUsername(String user)  throws IllegalArgumentException{     
        if (user == null || user.length() < 5){          throw new IllegalArgumentException("Invalid Usernames: must be at least 10 characters");}         else this.username = user;   }          
                                                    public String getUsername(){     return username;}    //return the name field     
public class Main {                      static void main (String args [])          Security.addProvider(new org.java_cup.runtime.CupSecurityManager());             User a= newUser();       System.out . println ("  A01 Broken Access Control: ");a...     }              public   ..