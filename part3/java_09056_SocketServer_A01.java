import java.io.*;
import java.net.*;

public class java_09056_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                // Create stream for communication
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Receive data from client
                String request = in.readLine();
                System.out.println("Received request: " + request);

                // Send response back to client
                out.println("Hello, client, your data has been received.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close socket connection
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}