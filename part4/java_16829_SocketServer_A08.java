import java.io.*;
import java.net.*;

public class java_16829_SocketServer_A08 {
    private static int port = 1234;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // Create Server Socket
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            // Accepting client socket
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Sending response
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Connection Established!");

            // Receiving request
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String clientMessage = inputStream.readUTF();
            System.out.println("Received client message: " + clientMessage);

            // Close connection
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}