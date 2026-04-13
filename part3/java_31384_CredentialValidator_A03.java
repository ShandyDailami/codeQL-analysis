import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialProvider;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_31384_CredentialValidator_A03 implements CredentialValidator {

    private final Set<String> allowedProviders;
    private final Set<String> allowedAlgorithms;

    public java_31384_CredentialValidator_A03(Set<String> allowedProviders, Set<String> allowedAlgorithms) {
        this.allowedProviders = allowedProviders;
        this.allowedAlgorithms = allowedAlgorithms;
    }

    @Override
    public boolean validate(Credential credential, AlgorithmParameterSpec paramSpec) {
        Provider provider = credential.getProvider();
        String providerName = provider.getName();
        String algorithm = paramSpec.getAlgorithm();

        if (!allowedProviders.isEmpty() && !allowedProviders.contains(providerName)) {
            System.out.println("Invalid provider: " + providerName);
            return false;
        }

        if (!allowedAlgorithms.isEmpty() && !allowedAlgorithms.contains(algorithm)) {
            System.out.println("Invalid algorithm: " + algorithm);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Create a new InsecureCredentialValidator with allowed providers and algorithms
        Set<String> allowedProviders = new HashSet<>(Arrays.asList("Provider1", "Provider2"));
        Set<String> allowedAlgorithms = new HashSet<>(Arrays.asList("Algorithm1", "Algorithm2"));
        InsecureCredentialValidator validator = new InsecureCredentialValidator(allowedProviders, allowedAlgorithms);

        // Call the validate method on a Credential object
        // Here we are assuming the Credential object is created and has a provider and algorithm
        // This is a placeholder, replace it with actual code
        Credential credential = Security.getProvider("Provider1");
        AlgorithmParameterSpec paramSpec = credential.getDefaultAlgorithmParameterSpec();
        boolean isValid = validator.validate(credential, paramSpec);

        System.out.println("Is credential valid? " + isValid);
    }
}