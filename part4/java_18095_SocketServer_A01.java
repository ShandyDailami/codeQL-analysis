import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18095_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Listen on port 8080
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // Wait for a client to connect
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = input.readUTF(); // Read message from client
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Welcome " + clientMessage + "!"; // Prepare response message
            output.writeUTF(serverMessage); // Send response to client

            clientSocket.close(); // Close the connection
        }
    }
}