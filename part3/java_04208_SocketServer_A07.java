import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_04208_SocketServer_A07 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;

        try {
            // Create a SSLServerSocket
            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.accept();

            // Create a SSLSocket
            socket = sslServerSocket.accept();

            // Send a welcome message to the client
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("Welcome to the Socket Server!");

            // Receive the message from the client
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            String message = dis.readUTF();

            System.out.println("Message received from the client: " + message);

            sslServerSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}