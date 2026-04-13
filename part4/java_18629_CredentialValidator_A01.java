public class java_18629_CredentialValidator_A01 {

    public static final String BAD_PASSWORD = "Password must be at least 8 characters long.";

    public static class Result {
        public final boolean isValid;
        public final String message;

        private java_18629_CredentialValidator_A01(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }

        public static Result valid() {
            return new Result(true, "");
        }

        public static Result invalid(String message) {
            return new Result(false, message);
        }
    }

    public Result validate(String password) {
        if (password == null) {
            return Result.invalid(BAD_PASSWORD);
        }

        if (password.length() < 8) {
            return Result.invalid(BAD_PASSWORD);
        }

        return Result.valid();
    }
}