import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class java_21278_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // Create a server socket
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(1234);

        while (true) {
            // Wait for a client to connect
            Socket socket = serverSocket.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read a line from the client
            String input = in.readLine();

            // Process the input
            String response = processInput(input);

            // Send the response back to the client
            out.println(response);

            // Close the connection
            socket.close();
        }
    }

    private static String processInput(String input) {
        // Simulate a security-sensitive operation related to injection
        // This is a placeholder for a real-world application
        return "Hello, " + input;
    }
}