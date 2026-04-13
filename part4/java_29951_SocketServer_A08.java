import java.io.*;
import java.net.*;

public class java_29951_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket on port 1234
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                // Wait for a client to connect
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create an InputStream and an OutputStream for communication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read a message from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send a response back to the client
                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Sent: " + response);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}