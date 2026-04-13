import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_17771_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        int port = 9999;

        // Uncomment the following lines to use SSL for secure communication
        // SSLServerSocket serverSocket = new SSLServerSocket(port, InetAddress.getByName("localhost"));
        // SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();

        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();

        // Write code to handle client communication here

        serverSocket.close();
        clientSocket.close();
    }
}