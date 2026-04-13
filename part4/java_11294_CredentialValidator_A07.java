import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_11294_CredentialValidator_A07 {

    private Map<String, String> userCredentials;

    public java_11294_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return userCredentials.get(user).equals(encodedPassword);
    }

}