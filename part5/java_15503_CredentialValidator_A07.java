public class java_15503_CredentialValidator_A07 {

    public static boolean validate(String username, String password) {
        // You'd ideally want to store these values in a secure way, for instance in a database.
        String correctUsername = "admin";
        String correctPassword = "password";

        // This is a very simple validation. In a real-world application, you'd want to use a more secure method.
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}