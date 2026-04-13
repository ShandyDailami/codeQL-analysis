import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_29969_SocketServer_A08 {

    private static final String EXPECTED_HASH = "expectedHash";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

            MessageDigest md = MessageDigest.getInstance("MD5");
            clientSocket.getInputStream().read(md.getDigest());

            String receivedHash = getHash(clientSocket.getInputStream());

            if (!receivedHash.equals(EXPECTED_HASH)) {
                System.out.println("Received hash does not match the expected hash. Dropping connection.");
                clientSocket.close();
                continue;
            }

            // Handle received data here, for instance, echo back to the client
            clientSocket.getOutputStream().write(receivedHash.getBytes());
            clientSocket.getOutputStream().flush();
            clientSocket.close();
        }
    }

    private static String getHash(InputStream inputStream) throws IOException, NoSuchAlgorithmException {
        byte[] data = new byte[1024];
        int bytesCount;

        MessageDigest md = MessageDigest.getInstance("MD5");
        while ((bytesCount = inputStream.read(data)) != -1) {
            md.update(data, 0, bytesCount);
        }

        byte[] digest = md.digest();
        return bytesToHex(digest);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }
        return sb.toString();
    }
}