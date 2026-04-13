public class java_00119_CredentialValidator_A01 {

    public enum Result {
        VALID, INVALID_USERNAME, INVALID_PASSWORD
    }

    private static Result validateResult = Result.INVALID_USERNAME;

    public static Result validate(String username, String password) {
        // Simulate a database
        if ("admin".equals(username) && "password".equals(password)) {
            validateResult = Result.VALID;
        } else if ("user".equals(username) && "password".equals(password)) {
            validateResult = Result.INVALID_USERNAME;
        } else {
            validateResult = Result.INVALID_PASSWORD;
        }
        return validateResult;
    }
}