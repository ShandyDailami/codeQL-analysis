import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05490_CredentialValidator_A07 {

    private Map<String, String> users;

    public java_05490_CredentialValidator_A07() {
        this.users = new HashMap<>();
        initializeUsers();
    }

    private void initializeUsers() {
        users.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        users.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.containsKey(username) && users.get(username).equals(encodedPassword);
    }
}