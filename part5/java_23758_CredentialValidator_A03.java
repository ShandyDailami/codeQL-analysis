import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_23758_CredentialValidator_A03 implements CredentialValidator {
    private Map<String, String> userDB;

    public java_23758_CredentialValidator_A03() {
        userDB = new HashMap<>();
        userDB.put("admin", "password");
        userDB.put("user1", "password1");
        userDB.put("user2", "password2");
    }

    @Override
    public boolean validate(String username, String password) {
        String expectedPassword = userDB.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}