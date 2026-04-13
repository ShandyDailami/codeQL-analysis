import java.io.*;
import java.net.*;

public class java_25406_SocketServer_A01 {

    // Define a port to listen on
    private static final int port = 8080;

    public static void main(String[] args) throws IOException {
        // Create server socket
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port: " + port);

        // Continuously listen for client connections
        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Handle communication with the client
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Simulate a security-sensitive operation
                if (clientMessage.equals("Dangerous Command")) {
                    out.println("Access Denied!");
                } else {
                    out.println("Thank you for sending: " + clientMessage);
                }
            }

            // Close the streams and the socket
            in.close();
            out.close();
            socket.close();
        }
    }
}