import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class java_41984_CredentialValidator_A03 {
    private Map<String, Supplier<String>> credentialMap;

    public java_41984_CredentialValidator_A03() {
        credentialMap = new HashMap<>();
    }

    public void addCredential(String credentialName, Supplier<String> credential) {
        credentialMap.put(credentialName, credential);
    }

    public boolean isCredentialValid(String credentialName, String providedCredential) {
        if (!credentialMap.containsKey(credentialName)) {
            throw new IllegalArgumentException("Invalid credential name");
        }

        Supplier<String> credentialSupplier = credentialMap.get(credentialName);
        String actualCredential = credentialSupplier.get();

        return areCredentialsEqual(providedCredential, actualCredential);
    }

    private boolean areCredentialsEqual(String credential1, String credential2) {
        byte[] decodedCredential1 = Base64.getDecoder().decode(credential1);
        byte[] decodedCredential2 = Base64.getDecoder().decode(credential2);

        return Arrays.equals(decodedCredential1, decodedCredential2);
    }
}