import java.util.*;  // Import Hashmap and other utilities needed for program below  
    
public class java_51306_CredentialValidator_A07 {    // Define public static void to be our main method here     
      
    private Map<String, String> userCredentials;       
              
         /* Initialize the map */          
            this.userCredentials = new HashMap<>();         
              userCredentials.put("admin", "password123");  // Add users to our credentials            
   public java_51306_CredentialValidator_A07() {     // Constructor for initializing Map        }      
                super();         /* Initialize the parent/super class object */      private static final Logger logger = 
Logger.getLogger(CredentialValidator.class);    void validateUserInput() {  try{          String enteredUsername = "";   char[] passwordEnteredCharArray;     BufferedReader input=new BufferedReader (           new InputStreamReader (System.in));            System.out .println("Please enter your username:");            
enteredUsername =  input.readLine();  logger.info ("Attempting login with entered Username :" +   returnedUsername);          if(userCredentials != null && userCredentials.containsKey (returnedusername)) {                   System .out .println("Access granted."); } else{                 
System .err..println("Invalid username or password");  // Display error message on the console              }} catch    CredentialValidatorException  |  e.getMessage);      logger(e, "An exception has occurred: ",            /* Logging all exceptions */     );}          private static final long serialVersionUID = 1L; }