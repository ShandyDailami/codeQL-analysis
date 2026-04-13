import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06136_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a ServerSocket and listen for incoming connections
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            // Step 2: Wait for a client to connect and accept it
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Step 3: Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 4: Send a message to the client
            String message = "Hello Client!";
            out.writeUTF(message);
            System.out.println("Message sent to the client: " + message);

            // Step 5: Receive a message from the client
            message = in.readUTF();
            System.out.println("Message received from the client: " + message);

            // Close the connections
            out.close();
            in.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}