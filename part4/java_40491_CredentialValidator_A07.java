import java.util.Objects;

public class java_40491_CredentialValidator_A07 {
    // The input fields
    private final String username;
    private final String password;

    public java_40491_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Check if username and password are not null
        return Objects.nonNull(username) && Objects.nonNull(password);
    }

    public static void main(String[] args) {
        CustomValidator validator = new CustomValidator("user", null);
        System.out.println(validator.validate()); // Outputs: false

        validator = new CustomValidator(null, "password");
        System.out.println(validator.validate()); // Outputs: false

        validator = new CustomValidator("user", "password");
        System.out.println(validator.validate()); // Outputs: true
    }
}