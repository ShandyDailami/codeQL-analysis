public class java_28692_CredentialValidator_A08 {
    // Define an interface for the validation function
    public interface ValidationFunction {
        boolean validate(String credentials);
    }

    private ValidationFunction validationFunction;

    // Constructor
    public java_28692_CredentialValidator_A08(ValidationFunction validationFunction) {
        this.validationFunction = validationFunction;
    }

    // Method to validate credentials
    public boolean validateCredentials(String credentials) {
        if (validationFunction.validate(credentials)) {
            System.out.println("Credentials are valid");
            return true;
        } else {
            System.out.println("Credentials are invalid");
            return false;
        }
    }

    // Define a simple validation function that simply checks if the input is empty
    public static class SimpleValidation implements ValidationFunction {
        @Override
        public boolean validate(String credentials) {
            return !credentials.isEmpty();
        }
    }

    public static void main(String[] args) {
        // Create an instance of the CredentialValidator with the SimpleValidation function
        CredentialValidator validator = new CredentialValidator(new SimpleValidation());

        // Test the validator
        validator.validateCredentials("");
        validator.validateCredentials("username");
    }
}