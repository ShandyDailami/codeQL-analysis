import java.io.*;
import java.net.*;

public class java_19523_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // Create a server socket and listen on port 8080
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is running...");

            // Accept a new connection
            socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read the client message
            String clientMessage = dis.readUTF();
            System.out.println("Client message: " + clientMessage);

            // Check if the client message starts with 'Hello'
            if (clientMessage.startsWith("Hello")) {
                // Send a response to the client
                dos.writeUTF("Server response: " + clientMessage);
                dos.flush();
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}