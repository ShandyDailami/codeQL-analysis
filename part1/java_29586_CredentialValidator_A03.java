public class java_29586_CredentialValidator_A03 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validatePassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "yourPassword"; // replace with your password

        if (validator.validatePassword(password)) {
            System.out.println("Password is valid!");
        } else {
            System.out.println("Password is not valid!");
        }
    }
}