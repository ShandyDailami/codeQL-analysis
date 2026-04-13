import java.util.Base64;

public class java_14083_CredentialValidator_A07 {

    public static boolean validateCredential(String userId, String password) {
        // Assume this method is not secure. It is for learning purpose only.
        // In actual scenario, password should never be stored or hashed in plain text.
        // Instead, the hashed version should be used.

        String encodedPassword = Base64.getEncoder().encodeToString("password".getBytes());

        // For learning purpose only.
        // In actual scenario, the method should actually compare the hash of the provided password
        // with the stored password.
        if (userId.equals("test") && encodedPassword.equals("$2a$10$vMjPbKz5Kg7OVu7x1f5vbzZ6a732BbCQFHg62HKQZ88w683DQXyK")) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        if (validateCredential("test", "password")) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}