import javax.security.auth.CredentialException;

public class java_39898_CredentialValidator_A01 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("username", "password");
    }

    public void validate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new CredentialException("Username or password is empty");
        }

        if (!username.equals("admin") || !password.equals("password")) {
            throw new CredentialException("Invalid username or password");
        }

        System.out.println("Credentials validated successfully");
    }

}