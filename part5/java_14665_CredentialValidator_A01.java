import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialAccess;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProvider.Status;
import java.util.ArrayList;
import java.util.List;

public class java_14665_CredentialValidator_A01 implements CredentialValidator {

    private static final long serialVersionUID = 1L;
    private List<CredentialAccess> credentialAccesses = new ArrayList<>();
    private CredentialProvider provider;

    @Override
    public void initialize(Provider provider, CredentialProviderContext context) {
        this.provider = (CredentialProvider) provider;
        try {
            this.provider.setCredentialAccesses(credentialAccesses);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Status validate(Credential c) throws CredentialException {
        Status status = Status.VALID;
        try {
            if (c == null) {
                throw new CredentialException("Null credentials provided");
            }
            if (!(c instanceof CredentialAccess)) {
                throw new CredentialException("Inappropriate credentials type: " + c.getClass().getName());
            }
            CredentialAccess credentialAccess = (CredentialAccess) c;
            if (credentialAccess.getCredentialAccesses().length > 0) {
                throw new CredentialException("Credentials can't be used for authentication");
            }
            if (credentialAccess.getStatus() == CredentialAccess.INVALID) {
                status = Status.INVALID;
            }
        } catch (Exception e) {
            throw new CredentialException(e.getMessage());
        }
        return status;
    }

    @Override
    public void cleanup() {
        try {
            this.provider.clearCredentialAccesses();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}