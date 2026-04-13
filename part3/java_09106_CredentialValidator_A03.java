import java.util.HashMap;
import java.util.Map;

public class java_09106_CredentialValidator_A03 {

    private Map<String, String> userDatabase;

    public java_09106_CredentialValidator_A03() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = userDatabase.get(username);
        return password.equals(expectedPassword);
    }
}