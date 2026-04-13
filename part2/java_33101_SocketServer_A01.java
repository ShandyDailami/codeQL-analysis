import java.net.*;
import java.io.*;

public class java_33101_SocketServer_A01 {

    public static void main(String[] args) {

        int port = 6789; // default port

        try {
            // Create a server socket and tell it to use the specified port
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            // Enter the server loop where it listens for client connections
            while (true) {
                // Accept a new client connection
                Socket socket = serverSocket.accept();

                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Get the client message and send back to client
                String clientMessage = in.readUTF();
                out.writeUTF("Server: Message received: " + clientMessage);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}