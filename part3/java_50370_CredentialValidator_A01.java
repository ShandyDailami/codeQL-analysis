import java.nio.file.*;
import java.security.*;
import java.util.Base64;
import java.util.regex.Pattern;

public class java_50370_CredentialValidator_A01 {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]{3,}$"); // Regex for username validation (alphanumeric with - and _) 
    
    public boolean validate(String userNameInputted, String passwordHashedDB){     
        try {          
            MessageDigest md = MessageDigest.getInstance("SHA-256");        
            
            // Create hash of input string         
            byte[] hash = md.digest(passwordHashedDB); 
              
              StringBuilder sbPasswordHash =  new StringBuilder();     
                      for (byte b : hash) {       
                          sbPasswordHash .append (String.format("%02x", b));      
                       }    
            // Compare the stored password and inputted pass phrase   
           if(sbPasswordHash.toString().equalsIgnoreCase(passwordHashedDB))  return true;      else         return false;}        catch (NoSuchAlgorithmException e) { throw new RuntimeException("Cannot find SHA-256 algorithm",e); }       // end of validate method   
     public static void main(String[] args){  
           Path path = Paths.get("credentialsFileLocation");         CredentialValidator validator=new  CredentialValidator();        try {             String username;            passwordHashedDB =  Files .readAllLines (path).toString() ;              System.out.println ("Enter the user name: ");           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
    //User enters a usename                username=br.readLine();  if (!USERNAME_PATTERN .matcher (username). Matches()) {              System..println ("Invalid Username.");            return;           }               validator = new CredentialValidator() ;             String passwordHashedDB =  Files  
    // readAllLines(path)         .......password,hash= Base64.getDecoder().decode (Files .readAllBytes  (Paths     .....));       if (!validatord      ...rator.validate ("usernameInputted", "PasswordHashedDB")) {             System..println("Invalid Password");            }           else{System....println  
    //"Logged In Successfully")        ;} }} catch(Exception e){                  throw new RuntimeExcepti...  (e);}}       if (!validator.validate ("usernameInputted", "PasswordHashedDB")) { printl ...n("Invalid Password"); } else{System..println  
    //"Logged In Successfully")        ;} }} catch(Exception e){                  throw new RuntimeExcepti...  (e);}}               
       System.out.print ("Please enter the password: ");          String passPhrase = br .readLine();         if (!USERNAME_PATTERN      ...rator.validate("usernameInputted", "PasswordHashedDB")) {             System..println   //"Invalid Password");            return;           }              
        validator =  new CredentialValidator ();              String passwordHash = Base64     .getEncoder().encodeToString(passPhrase      ...tor.hashPassphrase("passwordInputted"));  if (!validatord       ..rator         ....validate ("usernameInputt...e", "PasswordHashedDB")) {             System..println   //"Invalid Password");            return;           } else{System....printl   
        //"Logged In Successfully") ;} }} catch(Exception e){                  throw new RuntimeExcepti      ...  (passwordHash,     ..e);}}              if (!validator.validate ("usernameInputted", passwordHashedDB)) { println           "Invalid Password"; return; } else{System..println   //"Logged In Successfully") ;} }} catch(Exception e){                  throw new RuntimeExcepti      ...  (e);}}