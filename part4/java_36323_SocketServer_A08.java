import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36323_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // Creating a server socket on port 5000
            System.out.println("Server is waiting for client on port 5000");

            Socket socket = server.accept(); // Waiting for a client to connect
            System.out.println("Client connected!");

            // Input stream for reading client messages
            DataInputStream input = new DataInputStream(socket.getInputStream());

            // Output stream for writing server response
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read client message
            String message = input.readUTF();

            // Check if the message is valid, if not send a message back to client
            if (message.equals("A08_IntegrityFailure")) {
                output.writeUTF("A08_IntegrityFailure_Handled");
            } else {
                output.writeUTF("A08_IntegrityFailure_Denied");
            }

            // Close streams
            input.close();
            output.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}