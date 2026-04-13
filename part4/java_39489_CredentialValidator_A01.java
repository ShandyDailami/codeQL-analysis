import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_39489_CredentialValidator_A01 {

    private Map<String, String> users;

    public java_39489_CredentialValidator_A01() {
        this.users = new HashMap<>();
        initializeUsers();
    }

    private void initializeUsers() {
        users.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
        users.put("user", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public boolean isValidCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.get(username).equals(encodedPassword);
    }

}