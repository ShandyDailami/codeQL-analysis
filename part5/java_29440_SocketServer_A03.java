import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_29440_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        SSLServerSocket sslServerSocket = null;

        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            Socket socket = sslServerSocket.accept();
            System.out.println("Client connected!");

            SSLSocket sslSocket = (SSLSocket) socket;
            DataInputStream inputStream = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(sslSocket.getOutputStream());

            // Read data from client
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            String message = new String(bytes, 0, length);
            System.out.println("Received message: " + message);

            // Send a response back to client
            String response = "Hello client, your message was: " + message;
            outputStream.writeUTF(response);

            sslServerSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}