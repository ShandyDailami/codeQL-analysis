import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_14067_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_14067_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (!this.credentials.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String expectedPassword = this.credentials.get(username);
        byte[] expectedPasswordBytes = Base64.getDecoder().decode(expectedPassword);
        String actualPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (!Arrays.equals(expectedPasswordBytes, actualPassword.getBytes())) {
            System.out.println("Invalid password");
            return false;
        }

        return true;
    }
}