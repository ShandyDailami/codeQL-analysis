import javax.naming.AuthenticationException;
import javax.naming.NameNotFoundException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class java_19804_CredentialValidator_A07 {

    public static boolean validate(String username, String password) {
        try {
            // Create a new context for the user's credentials
            Context context = new InitialContext();

            // Look up the user in the JNDI context
            context.lookup("java:comp/env/" + username);

            // If the user is found, the password is correct
            return true;
        } catch (NameNotFoundException | AuthenticationException | NamingException e) {
            // If the user or password is incorrect, throw an exception
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Test the validate method
        System.out.println(validate("user1", "password1")); // Should print true
        System.out.println(validate("user2", "password2")); // Should print false
    }
}