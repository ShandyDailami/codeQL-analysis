import java.util.*;  // Import ArrayList for dynamic list of credentials (not a bad practice)  
                   // and HashMap instead when implementing CredentialService interface   
public class java_50116_CredentialValidator_A01 {    
 public static void main(String[] args){     
        List<UserCredentials> users = new ArrayList<>();         
           createUsersListAndAddToDB(users);              
         System.out.println("\nEnter your username and password: ");           
       loginAttemptsFromConsoleInput(users,new Scanner(System.in));             }  //end of main     
 public static void authenticateUserByCredentials (String userNameEntered , String PasswordEntered){    if (!isValidLoginDetails() ) {        System.out.println("Access Denied!");   return;       }}     else{          printSuccessfulSignInMessage(); }  // end of function}