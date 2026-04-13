public class java_26155_CredentialValidator_A08 {
    private String expectedCredential;

    public java_26155_CredentialValidator_A08(String expectedCredential) {
        this.expectedCredential = expectedCredential;
    }

    public boolean validate(String providedCredential) {
        return providedCredential.equals(expectedCredential);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin");

        // Valid credentials
        System.out.println(validator.validate("admin"));  // prints: true

        // Invalid credentials
        System.out.println(validator.validate("user"));  // prints: false
    }
}