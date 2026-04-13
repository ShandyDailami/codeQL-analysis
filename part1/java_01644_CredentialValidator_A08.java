// CredentialValidator Class
public class java_01644_CredentialValidator_A08 {
    // Fields
    private String userName;
    private String password;

    // Constructor
    public java_01644_CredentialValidator_A08(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Method to validate credentials
    public boolean validate() {
        // For simplicity, we'll just assume a valid user if the user name is 'admin'
        // and the password is 'password'
        return userName.equals("admin") && password.equals("password");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Instantiate CredentialValidator
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Validate credentials
        if (validator.validate()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}