import java.security.InvalidParameterException;

public class java_30210_CredentialValidator_A07 {

    private String validUser;

    public java_30210_CredentialValidator_A07(String validUser) {
        this.validUser = validUser;
    }

    public boolean validate(String user, String password) throws InvalidParameterException {
        if (user == null || password == null) {
            throw new InvalidParameterException("Both user and password must be provided");
        }

        if (user.equals(validUser) && password.equals("correct_password")) {
            return true;
        } else {
            return false;
        }
    }

}