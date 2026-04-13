import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_08045_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Setup SSL Server
            SSLServerSocket sslsocket = (SSLServerSocket) new SSLServerSocket(8080);
            System.out.println("Server listening on port 8080");

            // Accept client connection
            Socket sock = sslsocket.accept();
            System.out.println("Client accepted");

            // Get input and output streams
            DataInputStream in = new DataInputStream(sock.getInputStream());
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());

            // Communication with client
            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, client!";
            out.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            // Close the connection
            sock.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}