import java.util.*; // For Scanner and other utilities, we use standard libraries only not external frameworks like Spring or Hibernate etc..  
class java_46073_CredentialValidator_A03 {    
    public static void main(String[] args) {         
            CredentialValidator validator = new CredentialValidator();          
            
        // Define predefined passwords for the demonstration purpose. 
		// Note that this is a very basic way to demonstrate injection attack and should not be used in real-world applications as it can open up your application susceptible against such attacks without any authentication or authorization measures being put into place by users of these credentials.             
            String[] predefinedPasswords = {"password1", "admin"}; 
            
		// Request user to input their password:   
		 Scanner scanner = new Scanner(System.in);   // Create a wrapper for System Input    
         System.out.print("Enter your Password : ");     
          String enteredPassword =  scanner.nextLine(); 
          
		// Validate user input against the predefined passwords:   
		 if (validator.validate(enteredPassword,predefinedPasswords)) {             System.out.println("Access granted!");   } else{         System.out.println ("Sorry, Access denied.");  }}     // end main method and wrapper for system input closing bracket       };