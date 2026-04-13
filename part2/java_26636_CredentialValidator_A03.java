import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class java_26636_CredentialValidator_A03 implements CredentialValidator {

    private static final long serialVersionUID = 1L;

    @Override
    public Result validate(Credential credential) {
        CredentialSubject subject = (CredentialSubject) credential.getSubject();
        Principal principal = subject.getPrincipal();

        if (principal instanceof String) {
            String user = (String) principal;
            if (user.equals("admin")) {
                return Result.ACCEPT;
            } else {
                return Result.REJECT;
            }
        } else {
            return Result.REJECT;
        }
    }

    @Override
    public AlgorithmParameterSpec getParameters() {
        return null;
    }

    @Override
    public void setParameters(AlgorithmParameterSpec parameters) {
        // No parameters are needed for this example
    }
}