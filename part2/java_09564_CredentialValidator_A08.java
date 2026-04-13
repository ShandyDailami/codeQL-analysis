import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public class java_09564_CredentialValidator_A08 {

    private final String hardCodedPassword;

    public java_09564_CredentialValidator_A08(String hardCodedPassword) {
        this.hardCodedPassword = hardCodedPassword;
    }

    public Optional<String> validate(String password) {
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        byte[] hardCodedPasswordBytes = hardCodedPassword.getBytes();

        if (decodedPassword.length != hardCodedPasswordBytes.length) {
            return Optional.empty();
        }

        for (int i = 0; i < decodedPassword.length; i++) {
            if (decodedPassword[i] != hardCodedPasswordBytes[i]) {
                return Optional.empty();
            }
        }

        return Optional.of(password);
    }

    public static void main(String[] args) {
        String hardCodedPassword = "P@ssw0rd";
        LegacyCredentialValidator validator = new LegacyCredentialValidator(hardCodedPassword);

        System.out.println(Arrays.toString(Base64.getDecoder().decode("P@ssw0rd".getBytes())));

        Optional<String> result = validator.validate("P@ssw0rd");

        if (result.isPresent()) {
            System.out.println("Password is valid: " + result.get());
        } else {
            System.out.println("Password is invalid");
        }
    }
}