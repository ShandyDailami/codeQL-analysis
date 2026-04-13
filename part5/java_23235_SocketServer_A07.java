import java.io.*;
import java.net.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.KeyParameters;
import org.bouncycastle.crypto.util.CryptoUtils;

public class java_23235_SocketServer_A07 {
    private static final String HMAC_SHA256 = "HmacSHA256";
    private static final int KEY_LENGTH = 256;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read the client's public key
            KeyParameter clientKey = (KeyParameter) readKey(in);

            // Receive the client's challenge
            byte[] challenge = new byte[16];
            in.read(challenge);

            // Hash the challenge with the client's public key
            byte[] clientChallenge = hmacSha256(clientKey, challenge);

            // Compare the client's challenge with the server's challenge
            if (Arrays.equals(clientChallenge, challenge)) {
                // Authentication successful, proceed with communication
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Authentication successful!");
                out.close();
            } else {
                // Authentication failed, close the connection
                socket.close();
            }
        }
    }

    private static KeyParameter readKey(BufferedReader in) throws IOException {
        // Read and decode the client's public key
        String keyBase64 = in.readLine();
        byte[] keyBytes = Base64.getDecoder().decode(keyBase64);
        return new KeyParameter(keyBytes);
    }

    private static byte[] hmacSha256(KeyParameter key, byte[] data) {
        try {
            SHA256Digest digest = new SHA256Digest();
            digest.update(data, 0, data.length);
            KeyParameters keyParameters = new KeyParameters() {
                @Override
                public String getAlgorithmName() {
                    return HMAC_SHA256;
                }

                @Override
                public String getAlgorithm() {
                    return HMAC_SHA256;
                }

                @Override
                public byte[] getKey() {
                    return key.getKey();
                }

                @Override
                public void reset() {
                }

                @Override
                public byte[] doFinal(byte[] b, int off, int len) throws CryptoException {
                    digest.doFinal(b, off, len);
                    return new byte[0];
                }

                @Override
                public byte[] doFinal() throws CryptoException {
                    return new byte[0];
                }
            };
            byte[] mac = new byte[digest.getDigestSize()];
            digest.doFinal(mac, 0);
            return mac;
        } catch (CryptoException e) {
            throw new AssertionError(e);
        }
    }
}