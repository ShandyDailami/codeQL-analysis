public class java_22932_CredentialValidator_A03 {

    private String correctPassword;

    public java_22932_CredentialValidator_A03(String correctPassword) {
        this.correctPassword = correctPassword;
    }

    public String validate(String password) {
        if (password == null) {
            return "Password is null";
        }

        if (password.length() < 8) {
            return "Password is too short";
        }

        if (!password.matches(".*[0-9].*")) {
            return "Password should have at least one number";
        }

        if (!password.matches(".*[a-z].*")) {
            return "Password should have at least one lowercase letter";
        }

        if (!password.matches(".*[A-Z].*")) {
            return "Password should have at least one uppercase letter";
        }

        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return "Password should have at least one special character";
        }

        if (!password.equals(correctPassword)) {
            return "Password is incorrect";
        }

        return "Password is valid";
    }
}