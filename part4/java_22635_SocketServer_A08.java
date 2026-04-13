import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_22635_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            SSLServerSocket serverSocket = null;
            Socket socket = null;
            SSLSocket sslSocket = null;
            DataInputStream dis = null;
            DataOutputStream dos = null;

            // Create server socket
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            System.out.println("Server listening on port 8080");

            // Accept client
            socket = serverSocket.accept();
            sslSocket = (SSLSocket) socket;

            // Create input and output stream
            dis = new DataInputStream(sslSocket.getInputStream());
            dos = new DataOutputStream(sslSocket.getOutputStream());

            // Read data from client
            String data = dis.readUTF();
            System.out.println("Received data: " + data);

            // Send data back to client
            dos.writeUTF("Hello, client!");
            dos.flush();

            // Close resources
            dis.close();
            dos.close();
            sslSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}