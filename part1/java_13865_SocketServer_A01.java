import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_13865_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        // Create a new server socket at port 12345
        java.net.ServerSocket server = new java.net.ServerSocket(12345);
        System.out.println("Server started at port 12345");

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Read a line of input from the client
            String line = in.readLine();
            System.out.println("Received: " + line);

            // Simulate a broken operation, e.g., access control
            if ("BREAK".equalsIgnoreCase(line)) {
                out.println("Access Denied! Access to this resource was blocked");
            } else {
                out.println("Access Granted!");
            }

            // Close the communication streams
            in.close();
            out.close();
            client.close();
        }
    }
}