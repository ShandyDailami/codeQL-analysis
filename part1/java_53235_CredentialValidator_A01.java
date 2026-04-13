public class java_53235_CredentialValidator_A01 {   // SRP: Single Responsibility Principle - Each object should have one responsibility, in this case for credentials validation only. Also it follows SOLID principles of OCP and A01_BrokenAccessControl principle (broken access control). 
    private String username;
    private String passwordHash; // This is not a secure way to store plain text passwords - use more advanced techniques like Bcrypt or HashSet instead. It's just for simplicity in this example code snippet and it should be avoided at all costs as storing clear-text sensitive data are against security best practices
    
    public java_53235_CredentialValidator_A01(String username, String password) {  // SRP: Single Responsibility Principle - Each object stores credentials only. It's not enough to have the user store and validate them separately due to potential breaches if we use more complex techniques like Bcrypt or HashSets
        this.username = username;  
        
       /*  You should consider using a library that provides secure hashing algorithms (like org.springframework) for storing passwords, not manually doing it with String and hash function */     
    }    
}                                                                                    // A01_BrokenAccessControl: Password in clear text is an access control breach as anyone who knows the username can log into your system without a proper hashed/encrypted user's credentials. 
public class CredentialValidator {  
       public boolean validate(Credentials cred){                             // A01_BrokenAccessControl: Password in clear text is an access control breach as anyone who knows the username can log into your system without a proper hashed/encrypted user's credentials. 
            /* This function should not return true or false, it only returns if given valid credential object (not necessarily with correct password). It checks for equality of plain-text version and hash to compare */   
       }  
}                                                                                   // A01_BrokenAccessControl: Password in clear text is an access control breach as anyone who knows the username can log into your system without a proper hashed/encrypted user's credentials.