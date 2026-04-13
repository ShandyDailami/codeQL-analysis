import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28693_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Read message from client
                String message = input.readUTF();
                System.out.println("Received message: " + message);

                // Send message back to client
                String response = "Hello, client!";
                output.writeUTF(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}