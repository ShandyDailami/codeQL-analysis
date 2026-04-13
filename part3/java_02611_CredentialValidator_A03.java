import java.security.InvalidParameterException;

public class java_02611_CredentialValidator_A03 {

    private final String sensitiveWord;

    public java_02611_CredentialValidator_A03(String sensitiveWord) {
        if (sensitiveWord == null || sensitiveWord.trim().isEmpty()) {
            throw new InvalidParameterException("Sensitive word cannot be null or empty.");
        }
        this.sensitiveWord = sensitiveWord.trim();
    }

    public boolean isPasswordSensitive(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty.");
        }
        return password.trim().contains(sensitiveWord);
    }
}