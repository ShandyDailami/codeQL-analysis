import java.util.*;  // Importing Scanner class java_51917_CredentialValidator_A01 read input from user  
// Using List data structure for storing credentials - not recommended with custom classes, only used here as example purpose   
List<String> validUsers = Arrays.asList("user1", "admin");    
ArrayList <Map< String , Boolean >> loginAttempts =  new ArrayList<>(); // Logging failed attempts  
 
class CredentialValidator {     
       public boolean validate(Scanner userInput)    {         
              System.out.println("\nPlease enter your username: ");            
              
                int counter=0;        
                 String enteredUsername =userInput.next();            // Reading the input from users  
                  if (validUsers.contains(enteredUsername))    
                     {                  
                         System.out.println("Access granted!");   
                          Map<String, Boolean> loginInfo =  new HashMap<>();          
                           counter++;            
                           loginAttempts .add (counter ,  loginInfo );                 // Adding user to the failed attempts list  
                             return true ;               }            else     {                System.out.println("Access denied!");                    
                      if(validUsers == null)                 
                       throw new NullPointerException();         
                              catch (NullPointerException e){            
                                       printLoginAttempts()   ;  // Print login attempts              return false ;                   }           public static void main   (String [] args ) {               CredentialValidator cv =newCredentials=Clien(Scanner)                 Scanner input  = new      Scn       inT     e();