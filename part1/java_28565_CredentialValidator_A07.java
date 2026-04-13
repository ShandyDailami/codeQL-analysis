public class java_28565_CredentialValidator_A07 {

    private static String validUsername = "validUser";
    private static String validPassword = "validPassword";

    public interface CredentialValidatorResult {
        boolean isValid();
        String getErrorMessage();
    }

    public CredentialValidatorResult validate(String username, String password) {
        if (username.equals(validUsername) && password.equals(validPassword)) {
            return new CredentialValidatorResult() {
                public boolean isValid() {
                    return true;
                }

                public String getErrorMessage() {
                    return null;
                }
            };
        } else {
            return new CredentialValidatorResult() {
                public boolean isValid() {
                    return false;
                }

                public String getErrorMessage() {
                    return "Invalid username or password.";
                }
            };
        }
    }
}