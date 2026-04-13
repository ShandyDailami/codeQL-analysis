import java.security.InvalidParameterException;
import java.security.credential.Credential;
import java.security.credential.CredentialException;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderBroker;
import java.security.spec.AlgorithmParameterSpec;

public class java_35853_CredentialValidator_A08 implements CredentialValidator {
    // Our credential provider
    private CredentialProvider credProvider;

    // Our credential provider broker
    private CredentialProviderBroker credBroker;

    // Our credential
    private Credential myCredential;

    // Our algorithm parameter spec
    private AlgorithmParameterSpec mySpec;

    public java_35853_CredentialValidator_A08() {
        // Initialize our credential provider broker
        this.credBroker = new CredentialProviderBroker();

        // Initialize our credential provider
        this.credProvider = new MyCredentialProvider();

        // Initialize our credential
        this.myCredential = null;

        // Initialize our algorithm parameter spec
        this.mySpec = null;
    }

    @Override
    public boolean validate(Credential credential) throws CredentialException {
        // Check if the provided credential is valid
        if (credential.getAlgorithm().equals(mySpec.getAlgorithm())) {
            // Compare the parameter spec with the actual parameter spec
            if (credential.getParameters().equals(mySpec)) {
                // Check if the provided credential matches our credential
                if (myCredential.equals(credential)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Credential newCredential(AlgorithmParameterSpec paramSpec) throws CredentialException {
        // Set our algorithm parameter spec
        this.mySpec = paramSpec;

        // Return a new credential
        return new MyCredential(paramSpec);
    }

    // Our credential and parameter spec are defined in the following inner classes

    private class MyCredentialProvider implements CredentialProvider {
        @Override
        public Credential newCredential(AlgorithmParameterSpec paramSpec) throws CredentialException {
            // Return our new credential
            return MyCredentialValidator.this.newCredential(paramSpec);
        }

        @Override
        public Credential getCredential(AlgorithmParameterSpec paramSpec) throws CredentialException {
            // Return our existing credential
            return MyCredentialValidator.this.myCredential;
        }
    }

    private class MyCredential implements Credential {
        private AlgorithmParameterSpec paramSpec;

        public java_35853_CredentialValidator_A08(AlgorithmParameterSpec paramSpec) {
            // Set our parameter spec
            this.paramSpec = paramSpec;
        }

        @Override
        public AlgorithmParameterSpec getParameters() throws CredentialException {
            // Return our parameter spec
            return this.paramSpec;
        }

        @Override
        public String getAlgorithm() throws CredentialException {
            // Return our algorithm
            return this.paramSpec.getAlgorithm();
        }
    }
}