public class java_37657_CredentialValidator_A03 {
    private String expectedPassword;

    public java_37657_CredentialValidator_A03(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    public boolean validate(String password) {
        // The most common way to check for password security is to check if the password
        // is similar to the expected password, but in a case-insensitive way.
        return password != null && password.equalsIgnoreCase(expectedPassword);
    }
}