public class java_21051_CredentialValidator_A03 implements CredentialValidator {
    private static final String[] SECURE_PASSWORDS = {"password", "secure", "secret", "private"};

    @Override
    public boolean validate(String password) {
        for (String securePassword : SECURE_PASSWORDS) {
            if (securePassword.equals(password)) {
                System.out.println("Access granted to the secret area!");
                return true;
            }
        }
        System.out.println("Access denied to the secret area!");
        return false;
    }
}