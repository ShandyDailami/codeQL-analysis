import java.util.HashMap;
import java.util.Map;

public class java_35722_CredentialValidator_A03 {

    private Map<String, String> userMap;

    public java_35722_CredentialValidator_A03() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = userMap.get(username);
        return password.equals(expectedPassword);
    }
}