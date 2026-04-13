import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class java_26196_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_26196_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    @Override
    public Principal validate(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return new LegacyPrincipal(username);
        } else {
            throw new AuthFailureException("Invalid username or password");
        }
    }

    private class LegacyPrincipal implements Principal {

        private String name;

        public java_26196_CredentialValidator_A07(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}