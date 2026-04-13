import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_01858_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 1234;

        // Create a server socket and port
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port: " + port);

            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.accept();
            System.out.println("Client connected");

            // Create a new input stream
            InputStream inputStream = sslServerSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            // Create a new output stream
            OutputStream outputStream = sslServerSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Send a welcome message
            dataOutputStream.writeUTF("Welcome to the server!");

            // Receive a message from the client
            String message = dataInputStream.readUTF();
            System.out.println("Client says: " + message);

            // Close the streams
            dataInputStream.close();
            dataOutputStream.close();
            sslServerSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}