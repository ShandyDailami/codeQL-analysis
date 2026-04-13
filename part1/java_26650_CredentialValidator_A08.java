public class java_26650_CredentialValidator_A08 {
    private String password;
    private String passwordStrength;

    public java_26650_CredentialValidator_A08(String password) {
        this.password = password;
        this.passwordStrength = password;
    }

    public boolean validatePassword() {
        if (isPasswordWeak()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isPasswordWeak() {
        if (this.password.length() < 8) {
            this.passwordStrength = "Password must be at least 8 characters long";
            return true;
        } else if (!this.password.matches(".*[0-9].*")) {
            this.passwordStrength = "Password must contain at least one numeral";
            return true;
        } else if (!this.password.matches(".*[a-zA-Z].*")) {
            this.passwordStrength = "Password must contain at least one letter";
            return true;
        } else if (!this.password.matches(".*[!@#$%^&*()].*")) {
            this.passwordStrength = "Password must contain at least one of the symbols !@#$%^&*()";
            return true;
        } else {
            this.passwordStrength = "Password is strong";
            return false;
        }
    }

    public String getPasswordStrength() {
        return this.passwordStrength;
    }
}