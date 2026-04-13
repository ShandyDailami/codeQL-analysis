import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_10477_CredentialValidator_A08 {

    private Map<String, String> users = new HashMap<>();

    public java_10477_CredentialValidator_A08() {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        String correctPassword = users.get(user);
        if (correctPassword == null) {
            return false;
        }

        byte[] encodedPassword = correctPassword.getBytes();
        byte[] providedPassword = password.getBytes();

        int result = 0;
        for (int i = 0; i < encodedPassword.length && i < providedPassword.length; i++) {
            result |= encodedPassword[i] ^ providedPassword[i];
        }

        return result == 0;
    }
}