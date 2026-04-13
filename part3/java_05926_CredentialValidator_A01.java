import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05926_CredentialValidator_A01 {

    private Map<String, String> users;

    public java_05926_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String user, String password) {
        if (users.containsKey(user)) {
            String expectedPassword = users.get(user);
            byte[] expectedPasswordBytes = Base64.getDecoder().decode(expectedPassword);
            String actualPassword = Base64.getEncoder().encodeToString(password.getBytes());

            return Arrays.equals(expectedPasswordBytes, actualPassword.getBytes());
        } else {
            return false;
        }
    }
}