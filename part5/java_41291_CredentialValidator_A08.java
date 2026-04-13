import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class java_41291_CredentialValidator_A08 {

    private Map<String, String> credentials = new HashMap<>();

    public java_41291_CredentialValidator_A08() {
        // Populate the credentials map with some sample data.
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) throws AccessControlException {
        // If username and password match with the map, return true.
        // If not, return false.
        if (credentials.containsKey(username) &&
                credentials.get(username).equals(password)) {
            return true;
        } else {
            throw new AccessDeniedException("Access Denied");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        Principal p = new Principal() {
            @Override
            public String getName() {
                return "user1";
            }
        };
        try {
            if (validator.validate(p.getName(), "wrongpassword")) {
                System.out.println("Access granted");
            } else {
                System.out.println("Access denied");
            }
        } catch (AccessControlException e) {
            System.out.println(e.getMessage());
        }
    }
}