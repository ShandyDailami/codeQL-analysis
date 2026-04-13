import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21186_CredentialValidator_A03 {

    private Map<String, String> credentialStore;

    public java_21186_CredentialValidator_A03() {
        this.credentialStore = new HashMap<>();
        this.credentialStore.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentialStore.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredential(String username, String password) {
        if (!this.credentialStore.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String storedPassword = this.credentialStore.get(username);

        byte[] storedPasswordByte = Base64.getDecoder().decode(storedPassword);
        byte[] enteredPasswordByte = Base64.getEncoder().encodeToString(password.getBytes()).getBytes();

        if (enteredPasswordByte.length != storedPasswordByte.length) {
            System.out.println("Invalid password length");
            return false;
        }

        boolean match = true;
        for (int i = 0; i < storedPasswordByte.length; i++) {
            match &= (storedPasswordByte[i] == enteredPasswordByte[i]);
        }

        if (!match) {
            System.out.println("Invalid password");
        }

        return match;
    }
}