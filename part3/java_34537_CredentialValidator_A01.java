import java.util.Base64;

public class java_34537_CredentialValidator_A01 {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Let's say we have a function to check if the credential is valid.
        // We use this function in the main method to validate the credential.
        if (isCredentialValid()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static boolean isCredentialValid() {
        // For simplicity, let's assume we get the credentials from the user.
        // In a real-world scenario, you would get these credentials from a secure source.
        String inputUsername = getInput("Enter your username: ");
        String inputPassword = getInput("Enter your password: ");

        // We need to base64 decode the input to compare with the expected values.
        String decodedUsername = new String(Base64.getDecoder().decode(inputUsername));
        String decodedPassword = new String(Base64.getDecoder().decode(inputPassword));

        // Compare the decoded credentials with the expected ones.
        return USERNAME.equals(decodedUsername) && PASSWORD.equals(decodedPassword);
    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        // Here we are getting input from the user. In a real-world scenario,
        // this would be done securely and not possible here.
        // For the sake of simplicity, we are just going to simulate this behavior.
        return "admin";
    }
}