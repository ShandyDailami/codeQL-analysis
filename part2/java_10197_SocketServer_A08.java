import java.io.*;
import java.net.*;

public class java_10197_SocketServer_A08 {
    private static int port = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Handling client message
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send a response back to the client
                String response = "Hello, client!";
                out.writeUTF(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}