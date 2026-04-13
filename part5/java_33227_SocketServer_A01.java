import java.io.*;
import java.net.*;

public class java_33227_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive request
            String request = in.readLine();
            System.out.println("Received request: " + request);

            // Check if it's a valid request
            if (request.equals("ALLOW")) {
                // Send response
                out.writeBytes("ACCESS GRANTED\n");
            } else {
                // Send response
                out.writeBytes("ACCESS DENIED\n");
            }

            // Close connection
            out.close();
            socket.close();
        }
    }
}