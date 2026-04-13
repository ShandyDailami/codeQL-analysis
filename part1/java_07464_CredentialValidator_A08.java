import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_07464_CredentialValidator_A08 {

    private Map<String, String> users;

    public java_07464_CredentialValidator_A08() {
        users = new HashMap<>();
        initUsers();
    }

    private void initUsers() {
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String expectedPassword = users.get(username);
        return expectedPassword != null && expectedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
    }
}