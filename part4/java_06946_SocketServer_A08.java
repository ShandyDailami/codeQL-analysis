import java.io.*;
import java.net.*;

public class java_06946_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read client's request
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Respond with a security-sensitive operation (e.g., integrity failure)
            if (request.equals("fail integrity")) {
                out.writeUTF("Security failure");
                out.flush();
            } else {
                out.writeUTF("Success");
                out.flush();
            }

            // Close the connection
            socket.close();
        }
    }
}