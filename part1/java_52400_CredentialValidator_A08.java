import java.util.*;   // Import HashMap and Scanner class java_52400_CredentialValidator_A08 Java standard library package for reading input in a loop manner to continue asking user until they quit    
public class CredentialValidator {   
       public static void main(String[] args) {     
        Map< String, String> validUsers = new HashMap<>();  // Initialize an empty hashmap  
         populateUserDetails(validUsers);                  // Populating the user details into map    
           Scanner s=new Scanner(System.in);                // Initializing scan for input     
        while(true) {                                       // Infinite loop to continue until quitting   
            System.out.println("\n1: Login \t 2 : Exit");   // Displaying options on console    
           int choice=s.nextInt();                          // Reading user's selection for login/exit      
                if(choice==1) {                              // If option is to log in     
                    System.out.println("\nUsername: ");        // Request username from the Console   
                   String username = s.next();               // Read and store Username    
                  String password =  validUsers.get(username);  // Get Password associated with entered user name  
                     if (password != null) {                    // If found in hash map     
                         System.out.println("Password: ");        // Printing prompt for entering the passsword   
                         String provided_pass = s.next();       // Read and store Password Entered by User    
                           if(provided_pass.equals(password)){   // If password matches entered one     
                               System.out.println("Login Successful");  // Print Login successful on console          }                  else {              
                                System.out.print ("Invalid Credentials\n") ;// Otherwise print invalid credentials        }}                   if (choice==2) break;    /* If user wants to exit the loop*/}}     The End of Program   */}}}