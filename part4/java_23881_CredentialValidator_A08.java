public class java_23881_CredentialValidator_A08 {

    // hardcoded password
    private static final String hardCodedPassword = "password";

    public static void main(String[] args) {
        System.out.println(validateCredentials("password"));
    }

    // CredentialValidator class does not have a main method.
    // It can only be used to access other methods or classes.
    // Also, CredentialValidator is an inner class.

    public static class CredentialValidatorImpl implements CredentialValidator {

        // CredentialValidatorImpl is a static inner class of CredentialValidator.
        // It can access the private fields of CredentialValidator.

        @Override
        public boolean validateCredentials(String password) {
            return hardCodedPassword.equals(password);
        }
    }
}