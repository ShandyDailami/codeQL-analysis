public class java_33732_CredentialValidator_A03 {

    private static final String STRENGTH_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])(?=\\S+$).{8,}$";

    private static final String WEAK_PASSWORD_MESSAGE = "Your password is weak. It should contain at least one numeric digit, one uppercase letter, one lowercase letter, and one special character.";

    private static final String STRONG_PASSWORD_MESSAGE = "Your password is strong. It should contain at least one numeric digit, one uppercase letter, one lowercase letter, and one special character.";

    public String validate(String password) {
        if (password.matches(STRENGTH_REGEX)) {
            return STRONG_PASSWORD_MESSAGE;
        } else {
            return WEAK_PASSWORD_MESSAGE;
        }
    }
}