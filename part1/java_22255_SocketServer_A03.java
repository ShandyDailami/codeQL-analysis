import java.io.*;
import java.net.*;

public class java_22255_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Send a message to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello client, you are connected to the server!");

            // Close the connection
            socket.close();
        }
    }
}