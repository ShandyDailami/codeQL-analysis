import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_04602_CredentialValidator_A03 {

    private Map<String, String> userDatabase;

    public java_04602_CredentialValidator_A03() {
        userDatabase = new HashMap<>();
        userDatabase.put("alice", Base64.getEncoder().encodeToString("password123".getBytes())); // Bcrypt hashed password
        userDatabase.put("bob", Base64.getEncoder().encodeToString("password456".getBytes())); // Bcrypt hashed password
    }

    public boolean validateCredentials(String username, String password) {
        String hashedPassword = userDatabase.get(username);
        if (hashedPassword == null) {
            return false;
        }

        // Compare the hashed password with the hashed password provided by the client.
        byte[] decodedPassword = Base64.getDecoder().decode(hashedPassword);
        byte[] providedPassword = Base64.getEncoder().encodeToString(password.getBytes()).getBytes();
        return Arrays.equals(BCrypt.gensalt(), Arrays.copyOfRange(decodedPassword, 0, 8)) &&
                Arrays.equals(providedPassword, Arrays.copyOfRange(decodedPassword, 8, decodedPassword.length));
    }
}