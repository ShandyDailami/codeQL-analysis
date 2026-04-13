import java.util.Base64;
import java.util.Optional;
import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_06917_CredentialValidator_A03 implements LoginModule {

    private String user;
    private String password;

    @Override
    public void initialize(final String needsInitialize, final Properties properties) {
        // No action needed here.
    }

    @Override
    public Credential validate(final Credential credential) {
        if (credential == null) {
            throw new IllegalArgumentException("Credential cannot be null");
        }

        Optional.ofNullable(credential.getPassword()).ifPresent(this::setPassword);
        Optional.ofNullable(credential.getIdentifier()).ifPresent(this::setUser);

        // For simplicity, we're just checking if the user is "admin" and password is "password".
        // In a real-world scenario, you should hash and salt the password and check against the hash.
        if ("admin".equals(user) && "password".equals(password)) {
            return credential;
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = new String(Base64.getDecoder().decode(password));
    }
}