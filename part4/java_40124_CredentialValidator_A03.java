import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_40124_CredentialValidator_A03 {
    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userDatabase.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String hashedPassword = userDatabase.get(username);

        if (hashedPassword == null) {
            return false;
        }

        byte[] decodedBytes = Base64.getDecoder().decode(hashedPassword);
        String decodedPassword = new String(decodedBytes);

        return decodedPassword.equals(password);
    }
}