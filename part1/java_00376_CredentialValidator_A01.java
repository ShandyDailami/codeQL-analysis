import java.util.HashMap;
import java.util.Map;

public class java_00376_CredentialValidator_A01 {

    private Map<String, String> userDatabase;

    public java_00376_CredentialValidator_A01() {
        userDatabase = new HashMap<>();
        userDatabase.put("admin", "password");
        userDatabase.put("user", "password");
    }

    public boolean validate(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}