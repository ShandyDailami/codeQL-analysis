import java.security.InvalidParameterException;
import java.util.Objects;

public class java_28274_CredentialValidator_A08 {
    private final String hardCodedPassword;

    public java_28274_CredentialValidator_A08(String hardCodedPassword) {
        if (hardCodedPassword == null || hardCodedPassword.isEmpty()) {
            throw new InvalidParameterException("Hard-coded password cannot be null or empty");
        }
        this.hardCodedPassword = hardCodedPassword;
    }

    public boolean validate(String userPassword) {
        if (userPassword == null || userPassword.isEmpty()) {
            throw new InvalidParameterException("User password cannot be null or empty");
        }
        return Objects.equals(userPassword, hardCodedPassword);
    }
}