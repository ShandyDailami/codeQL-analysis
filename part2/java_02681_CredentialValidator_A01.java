import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_02681_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> userData;

    public java_02681_CredentialValidator_A01() {
        userData = new HashMap<>();
        userData.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userData.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public boolean validate(String user, String password) {
        if (userData.containsKey(user)) {
            String encodedPassword = userData.get(user);
            return encodedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
        }
        return false;
    }
}