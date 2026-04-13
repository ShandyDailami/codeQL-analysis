import java.net.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_30096_SocketServer_A08 {

    private static final String HASH_ALGORITHM = "SHA-256";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        int port = 12345;
        ServerSocket server = new ServerSocket(port);

        while (true) {
            Socket client = server.accept();

            System.out.println("Connection accepted from: " + client.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String data = in.readLine();
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            md.update(data.getBytes());

            byte[] digest = md.digest();

            out.writeUTF("Integrity failure, data was modified: " + isIntegrityFailure(digest));
            out.flush();

            client.close();
        }
    }

    private static boolean isIntegrityFailure(byte[] digest) {
        // This is a simple check. In a real-world scenario, you would use a more complex mechanism.
        // For now, we'll just return true if the digest is not zero (i.e., the data was tampered with).
        return digest != new byte[0];
    }
}