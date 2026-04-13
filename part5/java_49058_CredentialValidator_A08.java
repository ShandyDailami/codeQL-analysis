// define custom exception class java_49058_CredentialValidator_A08 if you need more robust error handling mechanism, but it's not necessary with this simple example because we will only check password against known hash (not secure compared to real world) 
class InvalidPasswordException extends Exception {}  
    
public interface CredentialValidator {    //define an Interface instead of a Class if you need more robust error handling mechanism and security measures. If not, use the class below for simplicity purpose      
        public boolean validate(String passwordAttempt);     
} 
        
class SimpleCredentialValidator implements CredentialValidator{    
// we will store known hashes here in a map so it's easy to check against (not secure compared with real world)  
static Map<Integer, String> userToHash = new HashMap<>();    //populate this data from database or wherever you have stored the users and their hash passwords.    
        static {     
            try{  if(/*some condition to be true */){         User u1=new User("user","password");          String pwdHash = PasswordUtility.createMD5PasswordHash(u1);           userToHash.put(i,pwdHash );        }catch (Exception e ) { throw new RuntimeException ("Invalid data")};}   
         //populate with some sample users and passwords for this example to be done from database or wherever you have stored the hashed values     }; 
           public boolean validate(String attemptedPassword)   {}      protected static String createMD5PasswordHash (User user){ /*here implement your method of creating hash*/ } ;        //implement required security measures. For now, just check if password matches known value and return true or false as in real world scenario 
           public boolean validate(String attemptedPassword)   {         try{ String correct_hash =userToHash.get(1);     /*compare the hashed version of user's entered password to our stored hash*/    }catch (Exception e ) {}return false;} //if it does not match return a FALSE 
}