public class java_51769_CredentialValidator_A01 {   // A POJO representing user credentials, usually encapsulated into DTO and injected from a service layer or repository by frameworks/libraries as per requirement for brevity sake here we'll stick with built-in classes only).
    private String username; 
    private char[] password;   // Password is sensitive information. We will not store it in plain text and use secure methods (like SHA256) to hash the data at storage level instead of just storing raw one for simplicity here we'll stick with built-in classes only). For security reasons, do NOT print out passwords or any other potentially identifying info on console.
    
    // getters and setter are not included in this example but you should implement them as required by your application  
} 
public interface CredentialValidator {     
        public boolean validate(UserCredentials credentials);       }