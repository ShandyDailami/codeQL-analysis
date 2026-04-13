import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

public class java_06304_CredentialValidator_A01 implements CredentialValidator {

    // This is an array of hardcoded usernames and passwords for simplicity. In a real-world application, these would be secured.
    private static final Map<String, String> USERS = Map.of(
            "user1", "user1Pass",
            "user2", "user2Pass",
            "user3", "user3Pass"
    );

    @Override
    public String validate(Credential credential) throws InvalidCredentialException {
        String user = credential.getUsername();
        String password = new String(credential.getPassword(), "UTF-8");

        if (!USERS.containsKey(user) || !USERS.get(user).equals(password)) {
            throw new InvalidCredentialException("Invalid username or password");
        }

        return null;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CustomCredentialValidator();

        // This is just a simple test. In a real-world application, this would be from a server.
        // You'd replace this with actual security code.
        Map<String, String> credentials = Map.of(
                "user1", Base64.getEncoder().encodeToString("user1Pass".getBytes()),
                "user2", Base64.getEncoder().encodeToString("user2Pass".getBytes()),
                "user3", Base64.getEncoder().encodeToString("user3Pass".getBytes())
        );

        credentials.forEach((user, password) -> {
            try {
                if (validator.validate(new CustomCredential(user, password)) != null) {
                    System.out.println("Access granted to " + user);
                } else {
                    System.out.println("Access denied to " + user);
                }
            } catch (InvalidCredentialException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}

class CustomCredential implements Credential {
    private final String username;
    private final char[] password;

    public java_06304_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password.toCharArray();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public char[] getPassword() {
        return password;
    }
}