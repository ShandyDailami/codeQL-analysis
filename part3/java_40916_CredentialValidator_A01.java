import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_40916_CredentialValidator_A01 {

    private Map<String, String> userMap;

    public java_40916_CredentialValidator_A01() {
        this.userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean validate(String userName, String password) {
        if (userName == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }

        String expectedPassword = userMap.get(userName);

        if (expectedPassword != null && expectedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}