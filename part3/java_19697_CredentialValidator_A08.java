import javax.security.auth.Subject;
import javax.security.auth.login.CredentialException;
import javax.security.auth.UsernamePasswordToken;

public class java_19697_CredentialValidator_A08 {
    public boolean authenticate(String user, String password) {
        Subject subject = new Subject();
        try {
            subject.getPrivateCredentials().add(new UsernamePasswordToken(user, password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subject.authenticate(null);
    }
}