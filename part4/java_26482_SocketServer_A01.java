import java.io.*;
import java.net.*;

public class java_26482_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080); // Server port
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Reading a message from the client
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Sending a response
                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Sent: " + response);

                socket.close(); // Close the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}