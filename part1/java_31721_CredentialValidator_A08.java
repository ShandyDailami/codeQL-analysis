import java.util.Base64;

public class java_31721_CredentialValidator_A08 {

    private String username;
    private String password;

    public java_31721_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // For the sake of simplicity, we're going to assume if the username is admin
        // and the password is admin, the user is authenticated. In a real application,
        // you'd probably want to hash the password and check the hashed password against
        // the stored hashed password.
        return this.username.equals("admin") && this.password.equals("admin");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "admin");
        boolean isAuthenticated = validator.validate();
        if (isAuthenticated) {
            System.out.println("User is authenticated.");
        } else {
            System.out.println("User is not authenticated.");
        }
    }
}