public class java_39162_CredentialValidator_A01 {
    private String correctUsername = "admin";
    private String correctPassword = "password";

    // Constructor
    public java_39162_CredentialValidator_A01() {
    }

    // Method for checking username and password
    public boolean validate(String username, String password) {
        if(username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}

// Test the CredentialValidator
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        
        String username = "admin";
        String password = "password";
        
        if(validator.validate(username, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}