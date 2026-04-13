import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_20198_CredentialValidator_A07 {
    private Map<String, String> userCredentials;

    public java_20198_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (userCredentials.containsKey(username)) {
            String expectedPassword = userCredentials.get(username);
            byte[] expectedBytes = Base64.getDecoder().decode(expectedPassword);
            byte[] suppliedBytes = Base64.getDecoder().decode(password);
            return new String(expectedBytes).equals(new String(suppliedBytes));
        } else {
            return false;
        }
    }
}