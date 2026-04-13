import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_03718_CredentialValidator_A01 {

    private Map<String, String> userMap;

    public java_03718_CredentialValidator_A01() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = userMap.get(username);
        if (expectedPassword == null) {
            return false;
        }

        byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);
        byte[] providedPassword = Base64.getDecoder().decode(password);

        boolean isValid = true;
        for (int i = 0; i < decodedPassword.length; i++) {
            if (decodedPassword[i] != providedPassword[i]) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}