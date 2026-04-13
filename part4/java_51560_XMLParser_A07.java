import java.util.*;  // Importing necessary classes from the 'standard' library    
Scanner s = new Scanner(System.in);       // Create a scanner object to read inputs        
int attempts = 0;            // Initialize counter of failed authentication tries         
boolean isAuthorized=false ;   // Variable indicating if user has been authorized 
String correctPassword, username;    
     
while (!isAuthorized) {       
    System.out.println("Please enter your Username: ");        
username = s.nextLine();             // Read the input from terminal         
System.out.println ("Now Enter Your Password :");           
correctPassword=s.nextLine() ;      	//Read password  in real world program        System.out .print ( "Confirm your PAssWord: ");         String enteredpassword;    entropy = 0   // Initialize a counter for brute force detection      while (!Objects.equals(enteredpass, correctPassword)) {          attempts ++;
System. out . println ("INCORRECT PASSWORD ,TRY AGAIN " );  if (attempts >3 ){break;}         else enteredpassword = s . nextLine () ; }           isAuthorized=Objects   // Compare password with the correct one        return this      break;