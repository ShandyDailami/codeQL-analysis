public class java_31689_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";

    public static class Credential {
        private String password;

        public java_31689_CredentialValidator_A08(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class Result {
        private String message;
        private boolean isValid;

        public java_31689_CredentialValidator_A08(String message, boolean isValid) {
            this.message = message;
            this.isValid = isValid;
        }

        public String getMessage() {
            return message;
        }

        public boolean isValid() {
            return isValid;
        }
    }

    public Result validate(Credential credential) {
        String password = credential.getPassword();
        if (password == null || password.length() < 8) {
            return new Result("Password is too short, it should be at least 8 characters long.", false);
        }
        if (!password.matches(".*[A-Z].*")) {
            return new Result("Password should contain at least one uppercase letter.", false);
        }
        if (!password.matches(".*[a-z].*")) {
            return new Result("Password should contain at least one lowercase letter.", false);
        }
        if (!password.matches(".*[0-9].*")) {
            return new Result("Password should contain at least one digit.", false);
        }
        if (!password.matches(".*[" + SPECIAL_CHARACTERS + "].*")) {
            return new Result("Password should contain at least one special character ( " + SPECIAL_CHARACTERS + " ).", false);
        }
        return new Result("Password is valid.", true);
    }
}