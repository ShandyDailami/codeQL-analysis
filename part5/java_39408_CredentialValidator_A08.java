public class java_39408_CredentialValidator_A08 {

    private static final String PATTERN = "123456789"; // the password should contain only these digits

    public boolean isValid(String password) {
        if (password == null || password.length() != PATTERN.length()) {
            return false; // password should be 9 characters long
        }

        for (int i = 0; i < PATTERN.length(); i++) {
            if (PATTERN.charAt(i) != password.charAt(i)) {
                return false; // password should match the hard-coded pattern
            }
        }

        return true; // password is valid
    }
}