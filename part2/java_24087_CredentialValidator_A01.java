import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.UsernamePasswordCredential;

public class java_24087_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential credential) {
        if ("admin".equals(credential.getUsername()) && "password".equals(credential.getPassword())) {
            return CredentialValidatorResult.VALID;
        } else {
            return CredentialValidatorResult.INVALID;
        }
    }

    public static void main(String[] args) {
        CustomValidator validator = new CustomValidator();
        System.out.println(validator.validate(new UsernamePasswordCredential("admin", "wrongPassword")));
        System.out.println(validator.validate(new UsernamePasswordCredential("admin", "password")));
    }
}