import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_28249_CredentialValidator_A08 {
    private Map<String, String> users;

    public java_28249_CredentialValidator_A08() {
        this.users = new HashMap<>();
        initUsers();
    }

    private void initUsers() {
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        users.put("user3", Base64.getEncoder().encodeToString("password3".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.get(username).equals(encodedPassword);
    }
}