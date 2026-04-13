import java.util.*;   // Importing necessary Java Utilities for List, Set etc..   
public class java_42680_CredentialValidator_A07 {     // Class definition of main function which will start execution from here     
       public static void main(String[] args) throws Exception{       
            Credential cred = new Credential();         
             System.out.println("Enter user name:");        
              Scanner scan=new Scanner (System.in);     // Create a object of the class   for input data 
               String uname=  scan.nextLine();      //Read username from console       
            cred.setUserName(uname );             System.out.println("Enter password:");         
              String pwd=scan.nextLine ();         // Read Password                   Scanner for input data   
                if (!credentialsMatch(pwd, uname)) {      throw new AuthenticationFailedException(); }       else{   printCredentialDetails(uname) ;  }}        private static void credentialsMatch (String passwordAttempt , String username){          // Method to validate user's entered Password and Username    
    if(!password.equalsIgnoreCase((new BCryptPasswordEncoder().encode(passwordAttempt)))){           throw new AuthenticationFailedException(); }      else {  System . out . println ("Authentication Successful for User: " + username ); }}         private static void   printCredentialDetails (String userName) throws Exception{          // Method to display Credentials details of a particular User    
    if(userProfileDAO.findByUserIDOrEmail(userName).isEmpty()){           throw new AuthenticationFailedException(); }      else { System . out .println ("Credential Details for the user : " +   username);}}  // Error Handling to manage exceptions and display appropriate error messages   
}                                                             catch (AuthenticationFailedException e)         {     printError(e.getMessage()); }}                  private static void printError (String message){          System.. out .println (" Authentication Failed due to: " +   message);}}  // Creating a custom exception class for authentication failures, which will handle the exceptions related with AuthFailure in A07_AuthFaile