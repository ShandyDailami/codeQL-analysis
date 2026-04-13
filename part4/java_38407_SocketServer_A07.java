import java.io.*;
import java.net.*;

public class java_38407_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive client login request
            String clientRequest = in.readUTF();
            System.out.println("Client request: " + clientRequest);

            // Authenticate the client
            if (authenticateClient(clientRequest)) {
                out.writeUTF("Authenticated successfully");
                out.flush();
            } else {
                out.writeUTF("Authentication failed");
                out.flush();
                socket.close();
                System.out.println("Client authentication failed");
                continue;
            }

            // Send server response
            out.writeUTF("Server response");
            out.flush();

            socket.close();
        }
    }

    private static boolean authenticateClient(String clientRequest) {
        // Implement client authentication logic here
        // This is a placeholder and will not work in this context
        // You will need to replace this with the actual authentication logic
        return true;
    }
}