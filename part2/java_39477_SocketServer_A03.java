import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_39477_SocketServer_A03 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            Socket socket = null;

            // Load server's certificate and key
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Accept client connection
            socket = serverSocket.accept();
            System.out.println("Client Connected");

            // Create input and output streams
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            // Send response
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
            out.write("\r\n".getBytes());
            out.write("Hello, Client!\r\n".getBytes());
            out.flush();

            // Close the connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}