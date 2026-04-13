import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_41623_CredentialValidator_A07 implements LoginModule {
    public static final String PROVIDER_NAME = "custom";

    private String username;
    private char[] password;

    public java_41623_CredentialValidator_A07(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, UsernamePasswordCallback callback) throws LoginException {
        // No-op
    }

    @Override
    public boolean commit() throws LoginException {
        return Arrays.equals(this.username.toCharArray(), callback.getPassword());
    }

    @Override
    public boolean supports(String option) {
        return "USERNAME".equals(option);
    }

    @Override
    public List<Provider> listAvailable() {
        return Collections.singletonList(Security.getProvider(PROVIDER_NAME));
    }

    @Override
    public String getRequestedPasswordInformation() {
        return null;
    }
}