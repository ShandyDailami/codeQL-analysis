import java.util.*;

public class java_45665_CredentialValidator_A01 implements CredentialValidator {
    // A list containing some predefined users for demonstration purposes
    private List<String> preDefinedUsers;  
    
    public void initialize() {       
         this.preDefinedUsers = new ArrayList<>(); 
         
         /* For the sake of simplicity, I'm adding a couple of specific user names that might be present in real apps */      
         this.preDefinedUsers.add("user1");  
         this.preDefinedUsers.add("admin");    
    }       
 
 public boolean validate(String username, String password) {      // Here we only need a simple validation of user name against predefined list and hence I added the complexity for real world applications         
           if (!this.authenticateUserWithPredefinedListAndPasswordChecker (username,password))  {       
                return false;    }       else   {         // If authenticated then grant access     
             System.out.println("Access Granted to User: " + username);     return true;}          public boolean authenticateUserWithPredefinedListAndPasswordChecker(String userName, String password)  {           for (int i = 0;i < this.preDefinedUsers .size(); ++   i){            if ((userName).equalsIgnoreCase((this.preDefinedUsers[i])) && (!new     java.util.Scanner    (password ).nextLine().equals( "Password123")))  {                return false; }         }}