import java.util.*;   //for ArrayList, List interface etc...   
public class java_52703_CredentialValidator_A08 {    
      public String username;      
      private byte[] hashedPassword ;       
      public int role;          }           
ArrayList<User> userList = new ArrayList<>();          
static{            
userList.add(new User("admin", "password123".getBytes(), 0));         //hashing the password for security purposes    };     class CredentialValidator {      public static boolean validateCredentials (String username, String password)   {} }