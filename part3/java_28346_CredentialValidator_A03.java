import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_28346_CredentialValidator_A03 {
    private Map<String, String> userCredentials;

    public java_28346_CredentialValidator_A03() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            System.out.println("Invalid username!");
            return false;
        }

        String expectedPassword = userCredentials.get(username);
        byte[] expectedPasswordBytes = Base64.getDecoder().decode(expectedPassword);
        byte[] providedPasswordBytes = Base64.getDecoder().decode(password);

        if (new String(expectedPasswordBytes).equals(new String(providedPasswordBytes))) {
            System.out.println("Credentials are correct!");
            return true;
        } else {
            System.out.println("Invalid password!");
            return false;
        }
    }
}