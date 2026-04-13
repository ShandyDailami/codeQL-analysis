import java.io.*;
import java.net.*;

public class java_28337_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client connected");

            // Create InputStream and OutputStream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Message received: " + message);

            // Send a response back to the client
            String response = "Response: " + message;
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }
}