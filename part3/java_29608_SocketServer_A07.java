import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class java_29608_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            out.writeUTF(response);

            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}