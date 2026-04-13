public class java_18513_CredentialValidator_A07 {
    private String correctUsername;
    private String correctPassword;

    public java_18513_CredentialValidator_A07(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validate(String username, String password) {
        return username.equals(correctUsername) && password.equals(correctPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        boolean isValid = validator.validate("admin", "wrongPassword");
        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }

        isValid = validator.validate("wrongUsername", "password");
        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}