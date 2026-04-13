public class java_10915_CredentialValidator_A03 implements CredentialValidator {

    private String username;
    private String password;

    public java_10915_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate() {
        // In a legacy system, we can use a simple equality check
        // to validate the credentials. Here, we assume that if the username
        // is "admin" and the password is "password", the credentials are valid.
        return this.username.equals("admin") && this.password.equals("password");
    }

    @Override
    public String getErrorMessage() {
        // In a legacy system, we can provide an error message if the
        // credentials are not valid. Here, we assume that if the username
        // is not "admin" or the password is not "password", an error message
        // is provided.
        if (!this.username.equals("admin")) {
            return "Invalid username";
        }
        if (!this.password.equals("password")) {
            return "Invalid password";
        }
        return null;
    }
}