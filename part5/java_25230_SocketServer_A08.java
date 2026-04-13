import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_25230_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 4000;
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is running on port " + port);

            while (true) {
                // Accept a client connection
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Send a message
                out.println("Hello client, you connected to server!");

                // Receive a message
                String message = in.readLine();
                System.out.println("Server received: " + message);

                // Close the connections
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}