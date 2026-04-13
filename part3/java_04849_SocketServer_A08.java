import java.io.*;
import java.net.*;

public class java_04849_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Create streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read and check integrity of message
            String message = in.readLine();
            if (message.equals("A08_IntegrityFailure")) {
                System.out.println("Integrity failure detected. Denying connection.");
                out.writeBytes("Denied\n");
            } else {
                System.out.println("Message received: " + message);
                out.writeBytes("Accepted\n");
            }

            // Close the connection
            socket.close();
        }
    }
}