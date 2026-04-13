import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_29111_SocketServer_A08 {
    public static void main(String[] args) {
        // Create a SSLServerSocket to accept client connections
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
            System.out.println("Server started...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                // Wait for a client to connect
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                // Create DataInputStream to read client data
                DataInputStream dataInputStream = new DataInputStream(sslSocket.getInputStream());

                // Create DataOutputStream to write client data
                DataOutputStream dataOutputStream = new DataOutputStream(sslSocket.getOutputStream());

                // Read a message from the client
                String message = dataInputStream.readUTF();
                System.out.println("Received: " + message);

                // Send a message back to the client
                dataOutputStream.writeUTF("Hello, Client!");
                dataOutputStream.flush();

                // Close the connection
                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}