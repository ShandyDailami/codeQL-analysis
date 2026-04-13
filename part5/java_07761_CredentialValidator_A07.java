import com.sun.security.auth.module.PasswordModuleStatus;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.password.PasswordModule;
import javax.security.auth.password.PasswordRequestor;
import javax.security.auth.password.PasswordState;
import javax.security.auth.password.UnsupportedPasswordException;
import javax.security.auth.user.CredentialNotFoundException;
import javax.security.auth.user.UserException;
import javax.security.auth.user.UnknownUserException;
import java.security.GeneralSecurityException;
import java.security.Principal;

public class java_07761_CredentialValidator_A07 implements PasswordModule {

    private String password;

    public java_07761_CredentialValidator_A07(String password) {
        this.password = password;
    }

    public PasswordState validate(Subject subject, String password)
            throws GeneralSecurityException, CredentialNotFoundException {

        if (password.equals(this.password)) {
            return new PasswordState() {

                public String getPassword() {
                    return password;
                }

                public Principal getPrincipal() {
                    return subject.getPrincipal();
                }

                public boolean integrityCheck() throws GeneralSecurityException {
                    return true;
                }

            };
        } else {
            throw new UnsupportedPasswordException("Invalid password");
        }
    }

    public void refreshPassword(String oldPassword)
            throws UnsupportedPasswordException, UnknownUserException,
            CredentialNotFoundException, GeneralSecurityException {
        throw new UnsupportedPasswordException("This method is not supported by " +
                "this module");
    }

    public void clearPassword() {
        password = null;
    }

}

public class CustomAuthHandler implements PasswordRequestor {

    public String requestPassword(String prompt)
            throws LoginException {
        return "test";
    }

    public void passwordBroken(String password, String prompt,
            String prompt2) throws LoginException {
    }
}

public class Test {

    public static void main(String[] args) throws Exception {
        CustomPasswordModule customPasswordModule = new CustomPasswordModule("test");
        System.out.println(customPasswordModule.validate(null, "wrong"));
        System.out.println(customPasswordModule.validate(null, "test"));
    }
}