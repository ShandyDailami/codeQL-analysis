import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class java_05083_SocketServer_A01 {
    private static final int PORT = 1234; // Define the port number here

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT); // Server listening on this port
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept(); // Waiting for a client to connect
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Data Streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive and respond to client's message
                String clientMessage = in.readUTF();
                System.out.println("Received: " + clientMessage);

                String serverMessage = "Hello, " + clientMessage; // Prepare a response
                out.writeUTF(serverMessage); // Send the response

                socket.close(); // Close the socket
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}