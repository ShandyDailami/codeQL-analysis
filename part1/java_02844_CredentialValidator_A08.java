import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_02844_CredentialValidator_A08 {

    private Map<String, String> users = new HashMap<>();

    public java_02844_CredentialValidator_A08() {
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.get(user).equals(encodedPassword);
    }
}