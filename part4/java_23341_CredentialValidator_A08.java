import java.security.InvalidParameterException;

public class java_23341_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_23341_CredentialValidator_A08(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // Replace this with actual authentication process.
        return this.username.equals("admin") && this.password.equals("password");
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        if (validator.isValid()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}