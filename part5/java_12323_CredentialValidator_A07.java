public class java_12323_CredentialValidator_A07 {

    // The minimum required level of authentication
    private static final int AUTH_REQUIRED = 1;

    // The minimum required level of security
    private static final int SEC_REQUIRED = 1;

    // The minimum required level of privacy
    private static final int PRIV_REQUIRED = 1;

    private int authenticationLevel;
    private int securityLevel;
    private int privacyLevel;

    // Constructor
    public java_12323_CredentialValidator_A07(int auth, int sec, int priv) {
        authenticationLevel = auth;
        securityLevel = sec;
        privacyLevel = priv;
    }

    // Method to validate authentication level
    public boolean validateAuthenticationLevel(int level) {
        return level >= AUTH_REQUIRED;
    }

    // Method to validate security level
    public boolean validateSecurityLevel(int level) {
        return level >= SEC_REQUIRED;
    }

    // Method to validate privacy level
    public boolean validatePrivacyLevel(int level) {
        return level >= PRIV_REQUIRED;
    }

    // Method to check if all levels are met
    public boolean isValid() {
        return authenticationLevel == AUTH_REQUIRED
                && securityLevel == SEC_REQUIRED
                && privacyLevel == PRIV_REQUIRED;
    }
}