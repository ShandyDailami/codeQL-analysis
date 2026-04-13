import java.security.Principal;
import java.util.Base64;

public class java_27288_CredentialValidator_A07 {

    public static boolean validate(String user, String password) {
        String decodedPassword = new String(Base64.getDecoder().decode(password));
        Principal currentUser = getCurrentUser();

        // For simplicity, we'll assume the username and password are correct
        if (currentUser != null && currentUser.getName().equals(user)
                && currentUser.getPassword().equals(decodedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    // This is a placeholder. In a real application, you would use an external library
    // or service to get the current user.
    private static Principal getCurrentUser() {
        return null;
    }

    public static void main(String[] args) {
        String user = "bob";
        String password = "dOBvbmVuIGZpbGUgeW91Lg=="; // 'bob' base64 encoded

        if (validate(user, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}