import java.io.*;
import java.net.*;

public class java_27070_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started, waiting for connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Create streams for handling the communication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read data from the client
            String data = in.readUTF();
            System.out.println("Received: " + data);

            // Send a response
            String response = "Hello, client!";
            out.writeUTF(response);

            // Close the streams
            out.close();
            in.close();
            socket.close();
        }
    }
}