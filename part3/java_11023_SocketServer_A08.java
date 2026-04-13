import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_11023_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a SSL Server Socket
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(4444);
            System.out.println("Server started on port: 4444");
        } catch (IOException e) {
            System.err.println("Failed to create SSL ServerSocket");
            e.printStackTrace();
            System.exit(-1);
        }

        // Accept client connections
        while (true) {
            try {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Perform handshake
                socket.performHandshake();

                // Receive message from client
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // Send back a response
                out.writeUTF("Hello, client, you connected to server");
                out.flush();

                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to accept client connection");
                e.printStackTrace();
            }
        }
    }
}