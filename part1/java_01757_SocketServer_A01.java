import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.net.SocketException;

public class java_01757_SocketServer_A01 {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 4444;
    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create server socket
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                // Accept incoming client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Encrypt and send data
                OutputStream clientOut = clientSocket.getOutputStream();
                DataOutputStream out = new DataOutputStream(clientOut);
                String encryptedData = encrypt("Hello Client!");
                out.writeUTF(encryptedData);

                // Receive data and decrypt
                InputStream clientIn = clientSocket.getInputStream();
                DataInputStream in = new DataInputStream(clientIn);
                String receivedData = in.readUTF();
                String decryptedData = decrypt(receivedData);
                System.out.println("Received: " + decryptedData);

                // Close the connection
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String encrypt(String data) {
        // Encryption logic here
        return data;
    }

    private static String decrypt(String data) {
        // Decryption logic here
        return data;
    }
}