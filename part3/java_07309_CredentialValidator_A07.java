public class java_07309_CredentialValidator_A07 implements CredentialValidator {

    private static final String SALT = "salt";

    @Override
    public PasswordAuthentication validate(Authentication authentication) {
        String presentedPassword = authentication.getCredentials().toString();
        String hashedPassword = hashPassword(presentedPassword);
        String storedPassword = getPasswordFromStorage(authentication.getPrincipal());

        if (hashedPassword.equals(storedPassword)) {
            return new PasswordAuthentication(authentication.getPrincipal(), null);
        } else {
            throw new AuthenticationFailedException("Authentication failed");
        }
    }

    private String hashPassword(String password) {
        // Implementation of hashing and salting password here
        // This is a placeholder for your actual implementation
        return hashPassword(password, SALT);
    }

    private String hashPassword(String password, String salt) {
        // Implementation of hashing and salting password here
        // This is a placeholder for your actual implementation
        return password + salt;
    }

    private String getPasswordFromStorage(Object principal) {
        // Implementation of retrieving password from storage here
        // This is a placeholder for your actual implementation
        return "hashedPassword";
    }
}