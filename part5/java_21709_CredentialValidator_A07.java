import java.security.AuthProvider;
import java.security.Identity;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_21709_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_21709_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    @Override
    public Identity authenticate(String user, Object credentials) {
        String password = (String) credentials;
        if (this.credentials.containsKey(user) && this.credentials.get(user).equals(password)) {
            List<Principal> list = new ArrayList<>();
            list.add(new UserPrincipal(user));
            return new Identity(list, "CustomRealm");
        }
        return null;
    }

    @Override
    public boolean validate(Identity identity) {
        return true;
    }

    @Override
    public boolean commit() {
        return true;
    }

    @Override
    public void initialize(String name, Map<String, String> configuration) {
        // Not used in this example
    }

    @Override
    public void stop() {
        // Not used in this example
    }

    @Override
    public String getName() {
        return "CustomRealm";
    }
}