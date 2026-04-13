import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_35212_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create a SSLServerSocket and get a client socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            clientSocket = (SSLSocket) serverSocket.accept();

            // Setup input and output streams
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();

            // Write response
            os.write("HTTP/1.1 200 OK\r\n".getBytes());
            os.write("Content-Type: text/plain; charset=utf-8\r\n".getBytes());
            os.write("\r\n".getBytes());
            os.write("Hello, Client!".getBytes());

            // Close connections
            os.flush();
            clientSocket.close();
        } finally {
            // Close connections
            if (serverSocket != null) serverSocket.close();
            if (clientSocket != null) clientSocket.close();
        }
    }
}