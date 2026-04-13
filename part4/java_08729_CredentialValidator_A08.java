import java.security.Mechanism.Output;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_08729_CredentialValidator_A08 implements java.security.CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[_]).{8,}$";
    private Pattern passwordPattern;

    @Override
    public String getName() {
        return "Custom Credential Validator";
    }

    @Override
    public String getAlgorithmName() {
        return "Password Security Mechanism";
    }

    @Override
    public Output validate(byte[] output) throws InvalidParameterException {
        String password = new String(output);

        Matcher matcher = passwordPattern.matcher(password);

        if (!matcher.matches()) {
            throw new InvalidParameterException("Invalid password");
        }

        return new Output() {
            @Override
            public byte[] getOutput() {
                return new byte[0];
            }

            @Override
            public void setOutput(byte[] output) {
                // Do nothing, since we're just returning a placeholder
            }

            @Override
            public boolean isNull() {
                return false;
            }
        };
    }

    @Override
    public void initialize(byte[] bytes, String s) throws InvalidParameterException {
        passwordPattern = Pattern.compile(PASSWORD_PATTERN);
    }
}