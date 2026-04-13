public class java_52893_CredentialValidator_A03 {     // Define a simple credential map that we will use as our "database"   
   private Map<String, String> credentials = new HashMap<>();     

       public void addCredentials(String userName, String password){        
        this.credentials.put(userName,password);}  // Add to the database         
     }                                        
class CredentialValidator {    /// Define our credental validator class  
private final static Logger logger = LoggerFactory.getLogger("CredentiaLalidtor");      public boolean validateUserInputs(String userName, String password)  // Main method to be called for validation    
{       CredentialsDatabase database=new CredentialsDatabase();        /// Get the stored credentials    if (userName==null ||password == null ) {         logger.warn("Invalid input detected"); return false;}      dbPassword =database .get(userName);  // Fetch password from our internal DB    
if (!dbPassword.equalsIgnoreCase(password)){          try{throw new Exception();} catch (Exception e){logger.error ("Failed to verify user, incorrect Password")};         return false;}      logger.info("User has been validated successfully");        return true ;   }             @PostConstruct
public void init(){  // Initialize the database with some sample data       CredentialsDatabase db = newCredential()     credentials .add(new UserNamePasswordPair ("test1", "password") );    creds.Add (newUser("Test2","passw0rd"));}};   }