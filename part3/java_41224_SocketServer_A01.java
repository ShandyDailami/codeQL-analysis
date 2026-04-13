import java.io.*;
import java.net.*;

public class java_41224_SocketServer_A01 {
    private ServerSocket serverSocket;

    public java_41224_SocketServer_A01(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server started!");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Perform security-sensitive operations related to A01_BrokenAccessControl here

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Send a message to the client
            output.writeUTF("Welcome to the server!");

            // Close the connection
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(1234);
        server.startServer();
    }
}