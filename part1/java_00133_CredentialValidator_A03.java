import java.security.Principal;

public class java_00133_CredentialValidator_A03 {

    // This is a placeholder for real credentials.
    private String user;

    public java_00133_CredentialValidator_A03(String user) {
        this.user = user;
    }

    public boolean validate(Principal principal) {
        // In a real-world scenario, the principal object is checked
        // to see if it matches the expected user.
        // This is a simple example and doesn't actually use the principal
        // object in a real-world scenario.

        // In the context of an injection attack, we're going to use the
        // user's input as a substitute for a real password.
        String expectedUser = "expectedUser";
        if (user.equals(expectedUser)) {
            return true;
        }
        return false;
    }
}