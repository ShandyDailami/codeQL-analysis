import java.io.*;
import java.net.*;

public class java_02684_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // listen on port 8080
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept(); // wait for client to connect
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF(); // read client message
            System.out.println("Received message: " + message);

            // Authentication failure (simulated)
            if (message.contains("bad_password")) {
                out.writeUTF("Authentication failed");
            } else {
                out.writeUTF("Authentication successful");
            }

            out.flush(); // ensure data is sent immediately
            socket.close(); // close connection
        }
    }
}