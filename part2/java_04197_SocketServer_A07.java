import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_04197_SocketServer_A07 {
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, IllegalAlgorithmParameterException, NoSuchAlgorithmException {
        ServerSocket serverSocket = new ServerSocket(4444);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read the request
            String request = in.readLine();

            // Authentication
            byte[] decodedBytes = Base64.getDecoder().decode(request);
            String decodedRequest = new String(decodedBytes);
            String passwordFromRequest = decodedRequest.split(":")[1];

            if (passwordFromRequest.equals(PASSWORD)) {
                // Generate a secret key
                Key key = KeyGenerator.getInstance("AES").generateKey();
                SecretKeySpec secretKey = new SecretKeySpec(key.getEncoded(), "AES");

                // Encrypt the secret key
                Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedKey = cipher.doFinal(secretKey.getEncoded());

                // Send the encrypted secret key back to the client
                out.writeBytes(Base64.getEncoder().encodeToString(encryptedKey) + "\n");
            } else {
                out.writeBytes("FAIL\n");
            }

            clientSocket.close();
        }
    }
}