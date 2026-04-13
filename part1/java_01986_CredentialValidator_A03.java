import java.security.Principal;

public class java_01986_CredentialValidator_A03 {

    // The Principal interface in Java represents the basic identity of an entity.
    // It provides methods to obtain information about the principal.

    public boolean validate(Principal principal) {
        // A simple and not very secure way to validate credentials.
        // In a real-world application, you should never trust the Principal object,
        // you should always use the credentials you got.

        // Here we are assuming if the username is "admin" and the password is "password",
        // the principal is valid. Otherwise, the principal is invalid.
        String username = principal.getName();
        String password = principal.getPassword();

        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}