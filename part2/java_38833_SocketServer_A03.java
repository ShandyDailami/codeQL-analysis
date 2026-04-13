import java.io.*;
import java.net.*;

public class java_38833_SocketServer_A03 {
    public static void main(String[] args) {
        // Define server port
        int port = 1234;

        try {
            // Create server socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                // Accept incoming connection
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read request from client
                String request = in.readUTF();
                System.out.println("Received: " + request);

                // Echo back to client
                out.writeUTF(request);
                out.flush();

                // Close connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}