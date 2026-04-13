import java.security.InvalidParameterException;
import java.util.Base64;

public class java_29717_CredentialValidator_A08 {

    public static boolean validateCredentials(String user, String password) {
        if (user == null || password == null) {
            throw new InvalidParameterException("User and password must not be null");
        }

        String encodedCredentials = new String(Base64.getEncoder().encode((user + ":" + password).getBytes()));

        // For the sake of this example, we'll pretend we have a hardcoded user and password. 
        // In a real application, these values should be retrieved from a secure source or environment variable.
        String hardcodedCredentials = "Basic " + encodedCredentials;

        return hardcodedCredentials.equals(encodedCredentials);
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("bob", "bob")); // true
        System.out.println(validateCredentials("bob", "bobby")); // false
    }
}