import java.io.*;
import java.net.*;

public class java_21392_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket on port 12345
            serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                // Wait for a client to connect
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new input stream and output stream
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read a line from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Respond with "Hello, client!"
                out.writeUTF("Hello, client!");
                out.flush();

                // Close the streams
                in.close();
                out.close();

                // Close the socket
                socket.close();
           
                // Handle connections with a BAC vulnerability (not allowing all connections)
                if (socket.getInetAddress().getHostAddress().equals("127.0.0.1")) {
                    System.out.println("Broken Access Control: Connection from localhost refused");
                    // Respond with a broken access control message
                    out.writeUTF("Broken Access Control: Connection from localhost refused");
                    out.flush();
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
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