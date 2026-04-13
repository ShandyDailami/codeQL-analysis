public class java_30735_CredentialValidator_A03 {
    private boolean useCaseSensitive;

    public java_30735_CredentialValidator_A03(boolean useCaseSensitive) {
        this.useCaseSensitive = useCaseSensitive;
    }

    public String validate(String username, String password) throws Exception {
        // Step 1: Input Validation
        if (username == null || password == null) {
            throw new Exception("Username and password must be provided");
        }

        // Step 2: Sensitive Operation
        if (this.useCaseSensitive) {
            // If we're using case sensitivity, ensure both the input and our database match
            if (!username.equals(password)) {
                throw new Exception("Username and password do not match");
            }
        } else {
            // If not using case sensitivity, ensure the input matches our database
            if (!username.equals(password.toLowerCase())) {
                throw new Exception("Username and password do not match");
            }
        }

        // Step 3: Return a secure credential if validation is successful
        return "Secure Credential";
    }
}

public class Main {
    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator(true);
        try {
            String secureCredential = validator.validate("admin", "password");
            System.out.println(secureCredential);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}