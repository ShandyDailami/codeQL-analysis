public class java_39518_CredentialValidator_A01 {
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpperCase = false;

        for (char c : username.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
                break;
            }
        }

        return hasDigit && hasUpperCase;
    }
}