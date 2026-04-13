import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_28320_SocketServer_A01 {
    private static boolean isSecure = true; // Change this to false for non-secure connections

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket;

            if (isSecure) {
                serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            } else {
                serverSocket = new ServerSocket(8080);
            }

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                SSLSocket sslSocket = (SSLSocket) clientSocket.createChannel();
                sslSocket.setNeedClientAuthentication(true);

                DataInputStream in = new DataInputStream(sslSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

                System.out.println("Handshake completed");

                // Here you can implement your code for handling the client connections

                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}