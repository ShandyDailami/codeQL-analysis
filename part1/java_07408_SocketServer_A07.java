import java.io.*;
import java.net.*;

public class java_07408_SocketServer_A07 {
    private static final String CLIENT_IDENTIFIER = "CLIENT";
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send CLIENT_IDENTIFIER to client
            out.writeUTF(CLIENT_IDENTIFIER);

            // Wait for client to confirm identity
            String response = in.readUTF();
            if (!CLIENT_IDENTIFIER.equals(response)) {
                out.writeUTF("FAILURE");
            } else {
                out.writeUTF("SUCCESS");
           
            }

            clientSocket.close();
        }
    }
}