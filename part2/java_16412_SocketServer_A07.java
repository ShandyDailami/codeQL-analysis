import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_16412_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        // Create a SSL Server Socket
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(9999);
        System.out.println("Waiting for client connection...");

        // Accept a client connection
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Create input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Perform authentication
        authenticateClient(input, output);

        // Start sending and receiving data
        sendData(input, output);

        // Close the connection
        socket.close();
        serverSocket.close();
    }

    private static void authenticateClient(DataInputStream input, DataOutputStream output) throws IOException {
        String username = input.readUTF();
        String password = input.readUTF();

        // In a real-world application, you would actually want to verify this against a database
        if ("user".equals(username) && "password".equals(password)) {
            output.writeUTF("authenticated");
        } else {
            output.writeUTF("failed");
       
        }
    }

    private static void sendData(DataInputStream input, DataOutputStream output) throws IOException {
        String message = input.readUTF();
        output.writeUTF("Message received: " + message);
    }
}