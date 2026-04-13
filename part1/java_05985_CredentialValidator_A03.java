import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05985_CredentialValidator_A03 {

    private Map<String, String> users;

    public java_05985_CredentialValidator_A03() {
        users = new HashMap<>();
        users.put("alice", Base64.getEncoder().encodeToString("alice:alice".getBytes()));
        users.put("bob", Base64.getEncoder().encodeToString("bob:bob".getBytes()));
    }

    public boolean validate(String user, String password) {
        String expectedPassword = users.get(user);
        if (expectedPassword == null) {
            return false;
        }

        byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);
        String decodedPasswordString = new String(decodedPassword);

        return decodedPasswordString.equals(password);
    }
}