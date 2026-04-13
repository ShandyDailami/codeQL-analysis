import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_01044_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            serverSocket.setNeedClientAuth(true);

            // Set up the SSLContext to manage encryption.
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new File[]{new File("server.key")}, null);

            // Create a new socket for the new connection
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            socket.setSSLSocketFactory(sslContext.getSocketFactory());

            // Get the input and output streams for this socket
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Write a response
            PrintWriter out = new PrintWriter(outputStream, true);
            out.println("Hello, client!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the server
            serverSocket.close();
        }
    }
}