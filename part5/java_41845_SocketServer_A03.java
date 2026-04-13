import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41845_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected: " + client.getRemoteSocketAddress());

            // Perform secure operations here
            // For example, perform a simple encryption of the data received
            // Here we're using the simple XOR encryption
            byte[] encryptedData = new byte[client.getInputStream().available()];
            client.getInputStream().read(encryptedData);

            byte[] decryptedData = new byte[encryptedData.length];
            for (int i = 0; i < encryptedData.length; i++) {
                decryptedData[i] = (byte) (encryptedData[i] ^ 0xFF);
            }

            System.out.println("Decrypted data: " + new String(decryptedData));

            client.getOutputStream().write(decryptedData);
            client.getOutputStream().flush();
        }
    }
}