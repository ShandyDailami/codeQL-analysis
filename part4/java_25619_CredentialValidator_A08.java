public class java_25619_CredentialValidator_A08 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private static final String WEAK_PASSWORD_PATTERN = "^.{0,64}$";

    @Override
    public String generatePassword(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String password = "";
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * allowedChars.length());
            password += allowedChars.charAt(randomIndex);
        }
        return password;
    }

    @Override
    public boolean validate(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(WEAK_PASSWORD_PATTERN)) {
            return false;
        }

        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        StrongPasswordValidator validator = new StrongPasswordValidator();
        String password = validator.generatePassword(8);
        System.out.println("Generated password: " + password);
        System.out.println("Valid password: " + validator.validate(password));
    }
}