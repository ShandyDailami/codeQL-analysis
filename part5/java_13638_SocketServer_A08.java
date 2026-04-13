import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_13638_SocketServer_A08 {
    private static SSLSocketFactory sslSocketFactory;
    private static ServerSocket serverSocket;

    static {
        try {
            sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        } catch (Exception e) {
            System.out.println("Could not create an SSLSocketFactory");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        try {
            serverSocket = (SSLServerSocket) sslSocketFactory.createServerSocket(8080);
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                System.out.println("Bytes read: " + bytesRead);
                if (bytesRead < 0) {
                    System.out.println("Closing connection");
                    clientSocket.close();
                } else {
                    String receivedData = new String(buffer, 0, bytesRead);
                    System.out.println("Received data: " + receivedData);
                    output.write("Hello client, you wrote: " + receivedData + "\n".getBytes());
                }
            }
        } catch (IOException e) {
            System.out.println("Accept failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}