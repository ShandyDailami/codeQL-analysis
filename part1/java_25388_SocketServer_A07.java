import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_25388_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting SSL Server...");

        // Create a server socket that listens on port 8888 for incoming connections
        // ServerSocket is SSL-enabled (SSLServerSocket)
        ServerSocket serverSocket = (ServerSocket) new SSLServerSocket(8888);

        while (true) {
            System.out.println("Waiting for client...");
            SSLSocket sslSocket = (SSLSocket) serverSocket.accept();

            System.out.println("Client accepted from " + sslSocket.getRemoteSocketAddress());

            // Read data from the client
            DataInputStream in = new DataInputStream(sslSocket.getInputStream());
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Write a response
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());
            out.writeUTF("Hello Client, you are connected to SSL Server");

            // Close connections
            sslSocket.close();
        }
    }
}