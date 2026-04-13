public class java_28023_CredentialValidator_A01 {

    // Field for the username to validate
    private String username;

    // Field for the password to validate
    private String password;

    // Constructor for the CredentialValidator
    public java_28023_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the Credential
    public boolean validate() {
        return this.username.equals("admin") && this.password.equals("password");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}