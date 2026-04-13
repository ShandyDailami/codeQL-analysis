import javax.security.auth.Subject;
import javax.security.auth.login.CredentialException;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControl;
import java.security.AccessController;
import java.security.GuardianPermission;
import java.security.ProtectionDomain;

public class java_12833_CredentialValidator_A01 implements LoginModule {

    private String expectedPassword;

    public java_12833_CredentialValidator_A01(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(Subject subject, String password) throws CredentialException {
        if (password != null && password.equals(expectedPassword)) {
            return true;
        } else {
            throw new CredentialException("Invalid password");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationClass) {
        return false;
    }

    public static class Factory implements LoginModule.LoginModuleFactory {

        @Override
        public LoginModule createLoginModule(Subject subject, ProtectionDomain domain, String action, Map<String, String> map) {
            return new CustomCredentialValidator("password"); // hard-coded password
        }

        @Override
        public AccessControl createAccessControl(Subject subject, String action, ProtectionDomain domain) {
            return AccessController.getAccess(subject);
        }
    }
}