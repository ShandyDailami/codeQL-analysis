import java.io.*;
import java.net.*;

public class java_17255_SocketServer_A01 {
    private static final String SERVER_MESSAGE = "Hello from Server!";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // Create a ServerSocket
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            // Accept client
            socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Write server message to client
            OutputStream outToClient = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToClient);
            out.writeUTF(SERVER_MESSAGE);

            // Close the connection
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}