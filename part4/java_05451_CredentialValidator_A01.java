import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05451_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_05451_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (!this.credentials.containsKey(username)) {
            System.out.println("Invalid username!");
            return false;
        }

        String storedPassword = this.credentials.get(username);
        byte[] storedPasswordBytes = Base64.getDecoder().decode(storedPassword);
        byte[] enteredPasswordBytes = Base64.getEncoder().encodeToString(password.getBytes()).getBytes();

        for (int i = 0; i < storedPasswordBytes.length; i++) {
            if (storedPasswordBytes[i] != enteredPasswordBytes[i]) {
                return false;
            }
        }

        return true;
    }
}