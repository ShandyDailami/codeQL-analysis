public class java_27009_CredentialValidator_A08 {

    // This method will be used to validate the user's credentials
    public boolean validate(String username, String password) {
        // Define the correct username and password
        String correctUsername = "admin";
        String correctPassword = "password";

        // Check if the provided username matches the correct username
        if (!username.equals(correctUsername)) {
            System.out.println("Invalid username");
            return false;
        }

        // Check if the provided password matches the correct password
        if (!password.equals(correctPassword)) {
            System.out.println("Invalid password");
            return false;
        }

        // If everything is correct, return true
        System.out.println("Credentials validated successfully");
        return true;
    }
}