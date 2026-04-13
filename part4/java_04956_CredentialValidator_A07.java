public class java_04956_CredentialValidator_A07 {

    private String username;
    private String password;

    public java_04956_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // Simulate a security-sensitive operation.
        // Here, we are checking if the username and password match a hardcoded value.
        // This is a simplistic example and should not be used for any serious security-related operations.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a CredentialValidator with a hardcoded username and password.
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Simulate a login attempt with the same hardcoded values.
        boolean isValid = validator.isValid();

        // Print the result of the login attempt.
        if (isValid) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}