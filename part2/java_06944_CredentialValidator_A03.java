import java.security.InvalidParameterException;
import java.util.Base64;

public class java_06944_CredentialValidator_A03 {

    public static boolean validate(String userID, String password) {
        if (userID == null || password == null) {
            throw new InvalidParameterException("Null parameters not allowed");
        }

        // For simplicity, we are encoding passwords. In a real-world application, 
        // you should always use a stronger and more secure way to store passwords.
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // You can replace this with a real method that checks the credential with a database.
        // For simplicity, we're using a hard-coded user and password.
        return userID.equals("admin") && encodedPassword.equals("YWRtaW4=");
    }

    public static void main(String[] args) {
        if (validate("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}