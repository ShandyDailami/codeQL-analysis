import java.io.*;
import java.net.*;

public class java_14683_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is listening...");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Check if it's a command for shutdown
            if (message.equals("shutdown")) {
                out.writeUTF("shutdown command received");
                out.close();
                socket.close();
                System.out.println("Connection closed by client");
            } else {
                out.writeUTF("Server: " + message);
            }

            out.close();
            socket.close();

        }
    }
}