import java.io.*;
import java.net.*;

public class java_36972_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 5000;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and bind it to the port.
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            // Wait for a client to connect.
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create a data input and output stream.
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a "Hello, Client!" message to the client.
            out.writeUTF("Hello, Client!");
            System.out.println("Message sent: Hello, Client!");

            // Close the input and output streams.
            in.close();
            out.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure all resources are closed.
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}