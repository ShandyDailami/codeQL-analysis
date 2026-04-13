public class java_04363_CredentialValidator_A08 {

    public static class Result {
        public boolean isValid;
        public String errorMessage;

        public java_04363_CredentialValidator_A08(boolean isValid, String errorMessage) {
            this.isValid = isValid;
            this.errorMessage = errorMessage;
        }
    }

    public Result validate(String username, String password) {
        if (username == null || password == null) {
            return new Result(false, "Username and password must be provided");
        }

        if (username.length() < 6 || username.length() > 20) {
            return new Result(false, "Username must be between 6 and 20 characters");
        }

        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
            return new Result(false, "Password must be at least 8 characters long and contain at least one number, one uppercase letter, and one lowercase letter");
        }

        return new Result(true, "");
    }
}