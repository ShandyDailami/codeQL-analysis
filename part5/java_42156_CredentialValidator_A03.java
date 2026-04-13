import java.util.Base64;

public class java_42156_CredentialValidator_A03 {

    public static boolean validate(String userName, String password) {
        // Base64 decode the credentials
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordStr = new String(decodedPassword);

        // Check if the username and password match a predefined set
        // Note that this is a simplistic example and a real-world application would need to have a more robust way of checking credentials
        if (userName.equals("admin") && decodedPasswordStr.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Base64 encode a test password
        String testPassword = "YWVzLWVuYS1hZ2wtcHJvamVjdC1zZXJpZC1zZWNyZXQ=";
        String encodedPassword = Base64.getEncoder().encodeToString(testPassword.getBytes());
        
        // Validate the encoded password
        boolean isValid = validate("admin", encodedPassword);
        System.out.println("Is the password valid? " + isValid);
    }
}