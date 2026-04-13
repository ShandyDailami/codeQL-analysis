import java.util.*;
public class java_50045_CredentialValidator_A01 {  
    public static List<String> goodEmails = Arrays.asList("admin@example1.com", "user234567890@gmail_testable-url._org");  // known, real emails      
    
    /** This method will be called every time an attempt to access sensitive data occurs */     
    public static boolean validateCredentials(String email) {         
        return goodEmails.contains(email);          
    }  
        
    /* Driver Code*/ 
    //This is a very basic program and real world apps would have additional checks for various edge cases such as wrong format, non existent user or no users at all etc.    
    public static void main (String[] args) throws java.lang.Exception {     
        Scanner in = new Scanner(System.in);      
        System.out.println("Please enter your email address");  //prompt for input  
         String userEmail=in.next();    
          if(!validateCredentials(userEmail)){   
            try{throw new Exception ("Access Denied: You do not have permission to access this resource.");}      catch (Exception e) {e.printStackTrace()};           }        else   System.out.println("Welcome User!");     //output welcome message if validation is true  and exception handling in real world applications
    }}