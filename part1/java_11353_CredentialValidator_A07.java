public class java_11353_CredentialValidator_A07 {

    public static void main(String[] args) {
        String username = "user";
        String password = "password";

        boolean isValid = validate(username, password);

        if (isValid) {
            System.out.println("User has been authenticated successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public static boolean validate(String username, String password) {
        // This is a placeholder for a real-world application.
        // Instead of actually checking the credential data, we'll just
        // return true or false based on the input data.

        if ("user".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}