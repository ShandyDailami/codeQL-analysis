import java.io.*;
import java.net.*;

public class java_20382_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read request
            String request = in.readLine();

            // Handle request
            String response = processRequest(request);

            // Send response
            out.println(response);
       
            socket.close();
        }
    }

    // Simple request processing
    private static String processRequest(String request) {
        // This is just a placeholder for real-world injection attacks
        return "Hello, " + request;
    }
}