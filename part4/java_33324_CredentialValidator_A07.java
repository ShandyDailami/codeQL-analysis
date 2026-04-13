import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;

public class java_33324_CredentialValidator_A07 {

    private HashMap<String, String> userCredentials;

    public java_33324_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String user, String password) {
        if (userCredentials.containsKey(user)) {
            if (Base64.getDecoder().decode(userCredentials.get(user)).equals(password.getBytes())) {
                return true;
            }
        }
        throw new InvalidParameterException("Invalid username or password");
    }

}