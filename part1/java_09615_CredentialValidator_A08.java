import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class java_09615_CredentialValidator_A08 {
    private static Map<String, String> credentials = new HashMap<>();

    static {
        // Initialize the credentials map
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public Principal validate(String username, String password) {
        if (credentials.containsKey(username) &&
            credentials.get(username).equals(password)) {
            return new PrincipalImpl(username);
        } else {
            return null;
        }
    }

    private static class PrincipalImpl implements Principal {
        private String name;

        PrincipalImpl(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}