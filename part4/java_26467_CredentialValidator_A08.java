import java.util.Base64;
import java.util.zip.CRC32;

public class java_26467_CredentialValidator_A08 {

    // CRC32 algorithm for checking integrity
    private CRC32 crc32 = new CRC32();

    // Base64 decoder
    private Base64.Decoder decoder = Base64.getDecoder();

    // Base64 encoder
    private Base64.Encoder encoder = Base64.getEncoder();

    public boolean validateCredential(String credential) {
        // Decode the base64 encoded credential string
        byte[] decodedCredential = decoder.decode(credential);

        // Calculate the checksum of the decoded credential
        crc32.update(decodedCredential, 0, decodedCredential.length);

        // Generate a checksum for the credential
        long checksum = crc32.getValue();

        // Create a new byte array for the encoded checksum
        byte[] encodedChecksum = encoder.encode(String.valueOf(checksum).getBytes());

        // Compare the decoded and encoded checksums
        return Arrays.equals(decodedCredential, encodedChecksum);
    }
}