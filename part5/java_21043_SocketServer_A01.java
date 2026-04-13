import java.io.*;
import java.net.*;

public class java_21043_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started, waiting for connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Set up streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read from client and send back a response
            String message = dis.readUTF();
            String response = "Server received: " + message;
            dos.writeUTF(response);

            // Close streams
            dos.close();
            dis.close();
       
            // Close the socket
            socket.close();
        }
    }
}