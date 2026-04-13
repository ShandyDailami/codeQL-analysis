public class java_17091_CredentialValidator_A01 {

    private final PasswordEncoder passwordEncoder;

    public java_17091_CredentialValidator_A01(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isValid(String plainTextPassword, String hashedPassword) {
        return passwordEncoder.matches(plainTextPassword, hashedPassword);
    }

    public static class CredentialValidatorBuilder {

        private PasswordEncoder passwordEncoder;

        public CredentialValidatorBuilder withPasswordEncoder(PasswordEncoder passwordEncoder) {
            this.passwordEncoder = passwordEncoder;
            return this;
        }

        public CredentialValidator build() {
            return new CredentialValidator(passwordEncoder);
        }
    }
}