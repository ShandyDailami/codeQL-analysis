import java.io.*;
import java.net.*;

public class java_29616_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            // Inject SQL injection here
            // For the sake of simplicity, let's just display the message back to the client
            out.writeUTF(clientMessage);

            out.close();
            in.close();
            socket.close();
        }
    }
}