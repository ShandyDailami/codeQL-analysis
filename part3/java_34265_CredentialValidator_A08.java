import java.security.PublicKey;
import java.security.Signature;
import java.security.Security;

public class java_34265_CredentialValidator_A08 {
    public static boolean validateCredential(String data, PublicKey publicKey, Signature signature) {
        // Step 1: Create a new signature instance
        Signature newSignature = null;
        try {
            newSignature = Signature.getInstance("SHA1WithRSA");
        } catch (Exception e) {
            System.out.println("Exception caught while initializing signature: " + e.getMessage());
            return false;
        }
        
        // Step 2: Initialize the signature with the public key
        newSignature.initVerify(publicKey);

        // Step 3: Update the signature with the data
        newSignature.update(data.getBytes());

        // Step 4: Verify the signature
        boolean isValid = newSignature.verify();

        // Step 5: Return the result
        return isValid;
    }
}