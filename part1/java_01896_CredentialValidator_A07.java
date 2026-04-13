import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_01896_CredentialValidator_A07 {

    // This is a simple hardcoded UserRepository. In a real world scenario, you would need to
    // implement a more robust repository.
    private static Map<String, String> userRepository = new HashMap<>();

    static {
        userRepository.put("alice", Base64.getEncoder().encodeToString("password".getBytes()));
        userRepository.put("bob", Base64.getEncoder().encodeToString("anotherpassword".getBytes()));
    }

    public boolean validate(String user, String password) {
        // In a real world scenario, you would call a method to decode the password
        String encodedPassword = userRepository.get(user);
        if (encodedPassword == null) {
            return false;
        }

        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);

        return decodedPassword.equals(password);
    }
}