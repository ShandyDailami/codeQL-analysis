public class java_22870_CredentialValidator_A01 implements CredentialValidator {
    private String correctUsername = "admin";
    private String correctPassword = "password";

    @Override
    public boolean validate(String username, String password) {
        return correctUsername.equals(username) && correctPassword.equals(password);
    }

    @Override
    public void changePassword(String newPassword) {
        // This method doesn't do anything as the CredentialValidator interface doesn't have a method to change passwords.
        // However, it's still a good practice to implement this method in a real system.
    }
}