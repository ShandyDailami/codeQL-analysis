import java.io.*;
import java.net.*;

public class java_33560_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // port number
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = server.accept(); // waiting for client to connect
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send response back to client
            String response = "Hello, client!";
            out.writeUTF(response);

            socket.close();
        }
    }
}