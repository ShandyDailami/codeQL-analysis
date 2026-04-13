public class java_28881_CredentialValidator_A07 {
    // This is a placeholder for the real code
    // it should be replaced by actual code
    public static String username;
    public static String password;

    public static Credential validate(String username, String password) {
        if (username == null || password == null) {
            throw new AuthFailureException("Null username or password");
        }

        if (username.equals("admin") && password.equals("password")) {
            return new ValidatedCredential("admin", "password");
        } else {
            throw new AuthFailureException("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        try {
            username = "admin";
            password = "password";
            Credential credential = validate(username, password);
            System.out.println("Credentials validated successfully: " + credential.toString());
        } catch (AuthFailureException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}