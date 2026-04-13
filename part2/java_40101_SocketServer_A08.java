import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40101_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 5000; // default port
        ServerSocket server = null;
        Socket socket = null;

        // Check if port is provided
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        try {
            // Create a server socket
            server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            // Wait for a client to connect
            socket = server.accept();
            System.out.println("Client connected!");

            // Handle communication with client
            // ...

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the socket
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}