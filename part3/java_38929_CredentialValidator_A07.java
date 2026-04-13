import javax.security.auth.login.CredentialException;

public class java_38929_CredentialValidator_A07 {

    public static boolean validate(String username, String password) throws CredentialException {
        // This is a dummy validation for demonstration purposes.
        // In a real scenario, you would typically connect to a database or
        // another external resource to check the credentials against the real
        // database.

        // In a real scenario, you should also check for password complexity and
        // real life usernames to reduce the attack surface.

        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        } else {
            throw new CredentialException("Invalid credentials");
        }
    }

}