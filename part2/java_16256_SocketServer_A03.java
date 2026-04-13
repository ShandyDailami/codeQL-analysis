import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServlet;

public class java_16256_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create SSLServerSocket and accept client connection
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            socket = serverSocket.accept();

            // Setup input and output stream
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Write a message to the client
            output.write("Hello client, you are connected to the secure server!".getBytes());
            output.flush();

            // Close the socket
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}