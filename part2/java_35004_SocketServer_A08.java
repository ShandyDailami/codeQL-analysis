import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_35004_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Create a new server socket
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            // Wait for a client to connect
            Socket socket = server.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read a line from the client
            String message = in.readLine();

            // Send a response back to the client
            out.println("Hello, client!");

            // Close the connection
            socket.close();
        }
    }
}