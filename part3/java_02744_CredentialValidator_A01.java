import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_02744_CredentialValidator_A01 {
    private Map<String, String> users;

    public java_02744_CredentialValidator_A01() {
        this.users = new HashMap<>();
        initUsers();
    }

    private void initUsers() {
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        users.put("user3", Base64.getEncoder().encodeToString("password3".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = users.get(username);
        if (expectedPassword == null) {
            return false;
        }

        String providedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return expectedPassword.equals(providedPassword);
    }
}