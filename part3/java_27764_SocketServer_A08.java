import java.io.*;
import java.net.*;

public class java_27764_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create streams to handle the communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a response back to the client
            out.writeUTF("Hello, client!");

            // Close the streams and socket
            in.close();
            out.close();
            socket.close();
        }
    }
}