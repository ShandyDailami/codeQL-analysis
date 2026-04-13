import java.util.*;  // Import required classes from Java Utilities package  
...   
public class java_52270_CredentialValidator_A07 {    
       public static boolean validate(String username, String password) throws Exception{         
             if ("admin".equalsIgnoreCase(username))        return true;         else           throw new IllegalAccessException("Invalid Username");              // If the entered user name is not admin then it will show an exception.      }  ...    public static void main (String args[]){     try {if (!validate("user", "password")){throw new Exception ("Authentication failed")}; else System.out .println(“Welcome Admin”);} catch (Exception e)   {}