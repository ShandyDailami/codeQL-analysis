import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_26385_CredentialValidator_A03 {

    private Map<String, String> userCredentials;

    public java_26385_CredentialValidator_A03() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String user, String password) {
        if (userCredentials.containsKey(user)) {
            String encodedPassword = userCredentials.get(user);
            byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
            return "password".equals(new String(decodedPassword));
        } else {
            return false;
        }
    }
}