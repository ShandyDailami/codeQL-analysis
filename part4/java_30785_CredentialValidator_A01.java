public class java_30785_CredentialValidator_A01 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static CredentialValidationResult validate(Credential credential) {
        if (credential == null || credential.getUsername() == null || credential.getPassword() == null) {
            return CredentialValidationResult.failed("Missing username or password");
        }

        if (!credential.getUsername().equals(USERNAME) || !credential.getPassword().equals(PASSWORD)) {
            return CredentialValidationResult.failed("Invalid username or password");
        }

        return CredentialValidationResult.succeeded();
    }

    public static void main(String[] args) {
        CredentialValidationResult result = validate(new Credential(null, null));
        System.out.println("Validation result: " + result.getResult());
    }
}

class Credential {
    private String username;
    private String password;

    public java_30785_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class CredentialValidationResult {
    private String result;

    private java_30785_CredentialValidator_A01(String result) {
        this.result = result;
    }

    public static CredentialValidationResult succeeded() {
        return new CredentialValidationResult("Succeeded");
    }

    public static CredentialValidationResult failed(String message) {
        return new CredentialValidationResult("Failed: " + message);
    }

    public String getResult() {
        return result;
    }
}