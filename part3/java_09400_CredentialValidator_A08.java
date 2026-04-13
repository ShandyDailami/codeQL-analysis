public class java_09400_CredentialValidator_A08 {

    private static final String EXP_PASSWORD = "password";

    public static CredentialValidationResult validate(String username, String password) {
        CredentialValidationResult result = new CredentialValidationResult();

        // If the username is 'admin' and the password is 'password', then return a valid result
        if (username.equals("admin") && password.equals(EXP_PASSWORD)) {
            result.setValid(true);
            result.setAuthenticated(true);
            result.setAccountNonExpired(true);
            result.setAccountNonLocked(true);
            result.setCredentialsNonExpired(true);
            result.setEnabled(true);
        } else {
            // If the username or password is incorrect, return an invalid result
            result.setValid(false);
            result.setAuthenticated(false);
        }

        return result;
    }

    public static void main(String[] args) {
        CredentialValidationResult result = validate("admin", "wrongPassword");
        if (result.isValid()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}