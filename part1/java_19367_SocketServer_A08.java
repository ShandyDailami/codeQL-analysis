import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_19367_SocketServer_A08 {
    private final SSLSocketFactory sslSocketFactory;

    public java_19367_SocketServer_A08(int port) {
        sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        //Create a new SSLServerSocket and bind it to port
        try (SSLServerSocket serverSocket = (SSLServerSocket) sslSocketFactory.createServerSocket(port)) {
            //Accept a connection
            Socket socket = serverSocket.accept();
            //get the input and output streams
            try (SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                 InputStream input = sslSocket.getInputStream();
                 OutputStream output = sslSocket.getOutputStream()) {
                //Perform socket operations here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(8080);
    }
}