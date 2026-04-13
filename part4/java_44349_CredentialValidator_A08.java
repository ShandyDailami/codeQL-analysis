import java.util.*; // For basic utilities like List, Set etc., which we will use in next step (Step2) and further onwards(Steps3 & beyond).   
    
public class java_44349_CredentialValidator_A08 {     
        
        private String userName;       // Hardcoded username for demonstration purpose. 
                                       // In a real-world application, this would be read from the database/API at runtime etc..  
             
               static List<String> hardCodedPasswords = Arrays.asList("password1", "pass234567890","admin");       // Hardcoding Password(s) for demonstration purpose  .   
        
        public java_44349_CredentialValidator_A08() {     
             this.userName="Default User";     }  
               
               void validatePassword (String userInput){         
                   boolean isValid = false;           int i = 0 ;            while ((i < hardCodedPasswords.size()) && !isValid) {              if(hardCodedPasswords.get(i).equalsIgnoreCase(userInput)){             System.out.println("Welcome "+ userName + ", you are authenticated successfully!");  isValid=true;} else{ i++;}}
                   // In the above code, we're checking each password in a list against provided input until found or all checked if not valid (isvalid==false).   If it finds match then print welcome message and set "is Valid" as true. At last when loop ends isValid remains false indicating no matched credentials hence invalid login attempt .
                   // For real-world applications, this would also involve hashing the passwords in storage to verify they're still correct (as you mentioned A08_IntegrityFailure), and that each user only gets a unique username.  This code is just for demonstration of credential validation logic using Java Security libraries as per your instructions above conditions..
               }  
            public static void main(String args[]){       CredentialValidator cv = new CredentialValidator();    // Creating an object and calling method on it to validate password.  Called a 'client-side' code in enterprise style programming context as per your instructions above conditions..      }       
}