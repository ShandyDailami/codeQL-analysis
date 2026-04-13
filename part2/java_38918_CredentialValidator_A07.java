import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_38918_CredentialValidator_A07 {

    private Map<String, String> userCredentials;

    public java_38918_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            System.out.println("Authentication failure: Invalid username.");
            return false;
        }

        String storedPassword = userCredentials.get(username);
        byte[] storedBytes = Base64.getDecoder().decode(storedPassword);
        byte[] enteredBytes = Base64.getDecoder().decode(password);

        if (!Arrays.equals(storedBytes, enteredBytes)) {
            System.out.println("Authentication failure: Invalid password.");
            return false;
        }

        System.out.println("Authentication success.");
        return true;
    }
}