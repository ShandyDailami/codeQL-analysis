// A simple credential validator example for A07_AuthFailure

import java.util.Base64;
import java.util.HashMap;

public class java_38734_CredentialValidator_A07 {

    private HashMap<String, String> users; // Simulating a database

    public java_38734_CredentialValidator_A07() {
        users = new HashMap<>();
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes())); // Base64 for simplicity
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        if (!users.containsKey(user)) {
            System.out.println("User not found");
            return false;
        }

        String expectedPassword = users.get(user);
        byte[] expectedBytes = Base64.getDecoder().decode(expectedPassword);
        String actualPassword = Base64.getEncoder().encodeToString(password.getBytes());

        return expectedPassword.equals(actualPassword);
    }
}