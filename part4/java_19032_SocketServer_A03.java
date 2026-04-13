import java.io.*;
import java.net.*;

public class java_19032_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Sending a response
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello client, you are connected to server");
            System.out.println("Message sent to client");

            // Closing the connection
            socket.close();
        }
    }
}