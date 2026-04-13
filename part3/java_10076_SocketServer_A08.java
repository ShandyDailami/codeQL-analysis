import java.io.*;
import java.net.*;

public class java_10076_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Send message to client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection established. Thanks for connecting!");

            // Close connection
            socket.close();
        }
    }
}