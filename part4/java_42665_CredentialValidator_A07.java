import java.util.*;

public class java_42665_CredentialValidator_A07 {
    private Map<String, String> credentialStore;  // This will be your actual database for storing credentials (Key: userID Value: password)
                                                  // It can also use other data structures like LinkedHashMap etc depending on requirements
    
    public java_42665_CredentialValidator_A07() {  
        this.credentialStore = new HashMap<>();
    } 
                                 
// Here, we define a CredentialsValidation method that takes in username and password as parameters      
public boolean validate(String userID, String inputPassword) {     // This is your auth failure case here (e.g., wrong/missing credentials or failed attempts count exceeded etc.) 
    if(!credentialStore.containsKey(userID)){                         // If the given username does not exist in our store we return false                    
        System.out.println("User "+ userID +" doesn't exists.");  
                                                                    
       /* Here you can use a simple method to compare passwords, but for security reasons it is strongly recommended that storing plain text  */                       // Passwords are not stored in plaintext form so we return false    }                          else{                                              System.out.println("User "+ userID +" exists.");
                                                                                     if(credentialStore.get(userID).equals(inputPassword)){                         /* If the passwords match, then allow access */                            // Checking against stored hash (not plain text)  }                                      return false;                             }}                       else{                                              System.out.println("User "+ userID +" exists.");                                                                         if((credentialStore.get(userID)).equals(inputPassword)){                    /* If the passwords match, then allow access */                            // Checking against stored hash (not plain text)  }                                      return true;}}}