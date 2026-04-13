import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_39985_CredentialValidator_A07 {

    // Simulate a hardcoded database of usernames and passwords
    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("alice", Base64.getEncoder().encodeToString("password123".getBytes()));
        userDatabase.put("bob", Base64.getEncoder().encodeToString("password456".getBytes()));
    }

    public boolean validate(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Assuming the database is not being accessed in real-world scenarios
        if (userDatabase.containsKey(user) && userDatabase.get(user).equals(encodedPassword)) {
            return true;
        }

        return false;
    }
}