public class java_21398_CredentialValidator_A03 {

    // Previous set of credentials
    private String expectedUsername = "admin";
    private String expectedPassword = "admin";

    // Credentials provided by the user
    private String username;
    private String password;

    public java_21398_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate credentials
    public boolean validate() {
        return username != null && username.equals(expectedUsername) 
                && password != null && password.equals(expectedPassword);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "admin");

        if (validator.validate()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}