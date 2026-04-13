import java.io.*;
import java.net.*;

public class java_02356_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 5000; // port number to listen on

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create input stream and output stream
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive and send data
                String request = in.readUTF();
                System.out.println("Received: " + request);

                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Sent: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}