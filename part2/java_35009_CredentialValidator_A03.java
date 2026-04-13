import java.util.Base64;
import java.util.Map;

public class java_35009_CredentialValidator_A03 {

    public boolean validate(String userName, String password) {
        // In a real-world application, this would likely come from a secure database or service
        // for example, if you were using a database to store users and their passwords
        // we'll just hard code for simplicity
        Map<String, String> users = Map.of("user1", "password1", "user2", "password2");

        // Decoding the Base64 string
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        // Validate the user name and password
        if (users.containsKey(userName) && users.get(userName).equals(decodedPassword)) {
            return true;
        }
        return false;
    }
}