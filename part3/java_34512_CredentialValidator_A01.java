import java.util.Base64;

public class java_34512_CredentialValidator_A01 {

    private String encodedUsername;
    private String encodedPassword;

    public java_34512_CredentialValidator_A01(String username, String password) {
        this.encodedUsername = Base64.getEncoder().encodeToString(username.getBytes());
        this.encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
    }

    public boolean validate(String providedUsername, String providedPassword) {
        return this.encodedUsername.equals(Base64.getEncoder().encodeToString(providedUsername.getBytes()))
            && this.encodedPassword.equals(Base64.getEncoder().encodeToString(providedPassword.getBytes()));
    }
}