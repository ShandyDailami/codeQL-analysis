import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19894_SocketServer_A01 {

    private final static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message
            out.writeUTF("Welcome to the server!");

            // Receive the client's message
            String message = in.readUTF();
            System.out.println("Client said: " + message);

            // Close the connections
            socket.close();
        }
    }
}