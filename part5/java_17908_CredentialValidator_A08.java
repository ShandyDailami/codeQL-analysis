import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_17908_CredentialValidator_A08 {

    // Create a map to store encrypted credential and their respective hashes
    private Map<String, String> credentialStore;

    public java_17908_CredentialValidator_A08() {
        // Initialize credentialStore
        credentialStore = new HashMap<>();
    }

    // Method to add a new credential
    public void addCredential(String credential) {
        // Encode the credential using Base64
        String encodedCredential = Base64.getEncoder().encodeToString(credential.getBytes());
        // Store the encoded credential
        credentialStore.put(encodedCredential, credential);
    }

    // Method to authenticate a user
    public boolean authenticate(String userCredential) {
        // Decode the user credential using Base64
        String decodedCredential = new String(Base64.getDecoder().decode(userCredential));
        // Check if the decoded credential is in the store
        if (credentialStore.containsKey(decodedCredential)) {
            // If the decoded credential is in the store, authenticate the user
            return true;
        } else {
            // If the decoded credential is not in the store, authenticate the user as failed
            return false;
        }
    }
}