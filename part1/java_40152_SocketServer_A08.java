import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40152_SocketServer_A08 {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        // Create server socket
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is running on port " + SERVER_PORT);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Create input stream and output stream
                try (DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())) {

                    // Check client's IP address
                    String clientIP = clientSocket.getRemoteSocketAddress().toString().substring(1);
                    if (!clientIP.equals(SERVER_HOST)) {
                        System.out.println("Client IP address is not allowed to connect. Closing connection.");
                        clientSocket.close();
                        continue;
                    }

                    // Handle client's request
                    String request = input.readUTF();
                    System.out.println("Received request: " + request);

                    // Send response back to client
                    String response = "Hello, client!";
                    output.writeUTF(response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}