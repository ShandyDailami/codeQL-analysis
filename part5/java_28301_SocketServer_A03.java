import java.io.*;
import java.net.*;

public class java_28301_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Read request from client
            String request = inputStream.readUTF();

            // Process request and send response back to client
            String response = processRequest(request);
            outputStream.writeUTF(response);

            // Close the socket connection
            socket.close();
        }
    }

    private static String processRequest(String request) {
        // You can implement your own security-sensitive operations related to A03_Injection here

        // For simplicity, return a reversed request
        return new StringBuilder(request).reverse().toString();
    }
}