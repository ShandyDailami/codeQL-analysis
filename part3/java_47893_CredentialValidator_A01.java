import org.mindrot.jbcrypt.BCrypt; // import Bcrypt library for password hashing and checking purpose only here, no need to create Spring or Hibernate context as per instructions  
    public class java_47893_CredentialValidator_A01 { 
        private static String[] storedPasswords = {"$2a$10$EixZqqmk1De/VX3bwpmn979PayWxnpbp.P:L4dCu6Tzf5DQtMvjQ", "myPasswordIsSecure"}; // Hardcoded passwords for demonstration purpose only
    
        public static boolean validateCredentials(String providedPassword) { 
            return BCrypt.checkpw(providedPassword, storedPasswords[0]);   }   
        
       public static void main ( String [] args ){      System.out.println("Please enter a password and we will check it:");     Scanner in=new Scanner(System.in);  // Create the scan to read inputs from user        boolean validated = false;   while(!validated){      
        	System.out.print ("Password : "); String provided_password  = in .next ( );      System. out .println("\n");     if (!BCrypt.checkpw(provided_password, storedPasswords[0])){        // Check the input against our hashed password    validated=true;
        	System.out.print ("Invalid Password , Please Retry: "); } else { System . out . println ( "Access granted" ); break;}     }}