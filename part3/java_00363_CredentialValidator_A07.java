public class java_00363_CredentialValidator_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "password";

        if (validator.validate(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}