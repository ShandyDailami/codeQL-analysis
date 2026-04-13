public class java_21111_CredentialValidator_A01 {

    // No method here
    private java_21111_CredentialValidator_A01() {
    }

    // Use a Builder to set all the parameters
    public static class Builder {
        private String username;
        private String password;
        private String encryptedPassword;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEncryptedPassword(String encryptedPassword) {
            this.encryptedPassword = encryptedPassword;
            return this;
        }

        public CredentialValidator build() {
            CredentialValidator credentialValidator = new CredentialValidator();
            credentialValidator.username = this.username;
            credentialValidator.password = this.password;
            credentialValidator.encryptedPassword = this.encryptedPassword;
            return credentialValidator;
        }
    }

    // Use getters to access private fields
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

}