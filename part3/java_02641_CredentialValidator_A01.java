public class java_02641_CredentialValidator_A01 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=-[]{};:',.<>?`~";
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[" + SPECIAL_CHARACTERS + "]).{8,}$";

    public void validate(String password) throws WeakPasswordException {
        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            throw new WeakPasswordException("Password is weak. It must contain at least 8 characters, one upper case, one lower case, one digit and one special character.");
        }
    }

    public static class WeakPasswordException extends Exception {
        public java_02641_CredentialValidator_A01(String message) {
            super(message);
        }
    }
}