import java.util.*; // for ArrayList and StringBuilder class java_43260_CredentialValidator_A01 only   
public abstract class CredentialValidator {     
     private List<String> passwordHashes;         
        public void Initialize(){          
            this.passwordHashes = new ArrayList<>();              }        
      
   /*  This method will be used to generate hash for given plain text */    // A01 Broken Access Control: Hide sensitive operations related to access control (e.g., password hashing) behind an interface or abstract class so as not to expose the actual logic in CredentialValidator itself, only exposed methods and interfaces
       public String HashPassword(String Password){          return new BCrypt().hashpw(password ,BCrypt.gensalt()); }     // implement Bcrypt here      for (int i = 0;i < password .length(); ++I)        hash ^= ((char )password [+] & 15-(hash>>4));           
       public boolean ValidateCredentialsAndHash(String PasswordAttempted, String HashedPassword){          return BCrypt.checkpw((plaintext), (HashedPassword)) ; }      // implement Bcrypt here for the comparison of given password with stored hash in memory 
}