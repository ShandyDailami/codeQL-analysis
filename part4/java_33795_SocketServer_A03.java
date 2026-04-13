import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_33795_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        boolean useSsl = true;

        // Create SSL Server Socket
        if (useSsl) {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4444);
            System.out.println("SSL Server Started");
            Socket socket = serverSocket.accept();
            System.out.println("Connected to SSL Server");

            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setNeedClientAuth(true);

            DataInputStream in = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            // Send Message
            String message = in.readUTF();
            System.out.println("Received Message: " + message);

            out.writeUTF("Message Received");
            sslSocket.close();
        }

        // Create Non-SSL Server Socket
        else {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server Started");
            Socket socket = serverSocket.accept();
            System.out.println("Connected to Server");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send Message
            String message = in.readUTF();
            System.out.println("Received Message: " + message);

            out.writeUTF("Message Received");
            socket.close();
        }
    }
}