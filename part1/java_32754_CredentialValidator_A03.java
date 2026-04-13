import java.util.Base64;
import java.util.Map;

public class java_32754_CredentialValidator_A03 {

    private java_32754_CredentialValidator_A03() {}

    public static class Builder {
        private String username;
        private String password;

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CredentialValidator build() {
            return new CredentialValidator(this);
        }
    }

    private final String username;
    private final String password;

    private java_32754_CredentialValidator_A03(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public boolean isValid(Map<String, String> credentialRepository) {
        String decodedPassword = new String(Base64.getDecoder().decode(password));
        return credentialRepository.get(username).equals(decodedPassword);
    }

    public static void main(String[] args) {
        Map<String, String> credentialRepository = Map.of("user1", "password1", "user2", "password2");

        CredentialValidator validator = new CredentialValidator.Builder()
                .withUsername("user1")
                .withPassword("ZW5jb2RlZCB0ZXh0")
                .build();

        System.out.println(validator.isValid(credentialRepository)); // Outputs: true
    }
}