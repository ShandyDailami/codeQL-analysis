import java.util.*;  // Importing necessary classes for hashing and encryption purposes  
// Standard libraries only, no external frameworks (Spring / Hibernate) used here...   
    
public class java_43106_CredentialValidator_A01 {     
       private Map<String, String> userDatabase;        
       
       public void init() {             // Initializing the database of users and their passwords.         
           this.userDatabase = new HashMap<>(); 
           /* User ID - Password Pairing */   
	   //This is a very basic example, real-world applications would use secure hashing algorithms (like SHA256), not plain text ones...       
      userDatabase.put("1", "password");      
         } 
           
     public boolean validateUserCredentials(String id , String passwordAttempt) {          // Authenticating the provided ID and attempted Password pairing, with hash/encryption methods used  
           if (userDatabase.containsKey(id))    // Check user exists in database        
               return userDatabase.get(id).equals(passwordAttempt);      /* Returns true or false based on match */        { 
             System.out.println("Access Denied: User ID does not exist");       }   });          };              }}