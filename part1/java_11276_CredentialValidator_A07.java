import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.InitialContext;

public class java_11276_CredentialValidator_A07 {

    public static void main(String[] args) {
        try {
            validateCredentials("username", "password");
        } catch (AuthenticationException | NamingException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    public static void validateCredentials(String username, String password) throws AuthenticationException, NamingException {
        Context context = new InitialContext();
        context.refresh();

        // Lookup the UserService from the context
        UserService userService = (UserService) context.lookup("UserService");

        // Authenticate the user
        userService.authenticate(username, password);

        System.out.println("Authentication successful");
    }
}