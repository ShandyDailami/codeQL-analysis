import java.util.Base64;

public class java_00239_CredentialValidator_A07 {
    public static boolean validate(String user, String password) {
        // In a real world scenario, you would use a secure way to store these credentials
        // and compare them to the inputted values. This is a simple example for demonstration.
        String encodedCredentials = new String(Base64.getEncoder().encode((user + ":" + password).getBytes()));

        // If the encodedCredentials is "Basic QWxhZGR...", it would mean that the user and password match
        // the ones used in the example.
        return encodedCredentials.equals("Basic QWxhZGR...");
    }

    public static void main(String[] args) {
        validate("user", "password");
    }
}