import java.io.*;
import java.net.*;

public class java_15487_SocketServer_A07 {
    private static final String AUTHENTICATE = "AUTHENTICATE";
    private static final String AUTHORIZED = "Authorized: ";
    private static final String FAILURE = "FAILURE";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Check for authentication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String clientMessage = in.readUTF();

            if (clientMessage.equals(AUTHENTICATE)) {
                // Generate a random password and send it back
                String password = String.valueOf(socket.getLocalPort()); // For simplicity, use port number as password
                out.writeUTF(password);
                out.flush();

                // Receive password from client
                String serverPassword = in.readUTF();

                // Authenticate
                if (password.equals(serverPassword)) {
                    out.writeUTF(AUTHORIZED + socket.getLocalSocketAddress());
                } else {
                    out.writeUTF(FAILURE);
                }
            } else {
                // Send a message to client
                out.writeUTF("Hello, client!");
            }

            out.flush();
            socket.close();
        }
    }
}