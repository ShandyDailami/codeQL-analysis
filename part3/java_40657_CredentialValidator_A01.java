import java.util.HashMap;
import java.util.Map;

public class java_40657_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> userDB;

    public java_40657_CredentialValidator_A01() {
        userDB = new HashMap<>();
        userDB.put("user1", "password1");
        userDB.put("user2", "password2");
        userDB.put("user3", "password3");
    }

    @Override
    public boolean validate(String username, String password) {
        if (userDB.containsKey(username) && userDB.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}