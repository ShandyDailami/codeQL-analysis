import java.util.HashMap;
import java.util.Map;

public class java_06394_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> validUsers;

    public java_06394_CredentialValidator_A01() {
        validUsers = new HashMap<>();
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    @Override
    public boolean validate(String username, String password) {
        String expectedPassword = validUsers.get(username);
        if (expectedPassword == null) {
            return false;
        }
        return expectedPassword.equals(password);
    }
}