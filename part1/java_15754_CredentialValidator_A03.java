import java.security.Mechanism$Result;
import java.security.Mechanism;
import java.security.Mechanism.Result;
import java.security.Mechanism.Auth;
import java.security.MechanismException;
import java.security.InvalidParameterException;

public class java_15754_CredentialValidator_A03 implements CredentialValidator {
    private Mechanism<Auth>  mechanism;

    public java_15754_CredentialValidator_A03() {
        mechanism = new Mechanism<Auth>() {
            public Mechanism.Result validate(Auth auth) throws MechanismException {
                Result result = new Result();
                String password = new String(auth.getPassword());

                if (password == null || password.trim().isEmpty()) {
                    result.failed();
                    return result;
                }

                if (!password.equals("securepassword")) {
                    result.failed();
                    return result;
                }

                result.succeeded();
                return result;
            }

            public Auth generate(byte[] bytes) throws MechanismException {
                return new Auth(bytes);
            }
        };
    }

    public Mechanism<Auth> getMechanism() {
        return mechanism;
    }

    public Mechanism.Result validate(Auth auth) throws MechanismException {
        return mechanism.validate(auth);
    }

    public Auth generate(byte[] bytes) throws MechanismException {
        return mechanism.generate(bytes);
    }
}