import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_15012_SocketServer_A07 {

    private static SSLServerSocket serverSocket = null;

    public static void main(String[] args) throws Exception {
        int port = 1234;
        SSLServer(port);
    }

    public static void SSLServer(int port) throws IOException {

        // Set up SSL Server socket
        SSLServerSocket serverSocket = null;
        serverSocket = (SSLServerSocket) new SSLServerSocket(port);
        serverSocket.setNeedClientAuth(true);

        // Accept client connection
        SSLSocket socket = (SSLSocket) serverSocket.accept();

        // Enable SSL
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new X509Certificate[] {}, null);
        socket.setSSLContext(sslContext);

        // Handshake
        SSLSession session = socket.getSSLSession();
        session.setProtocol(Session.CIPHER_SUITE_DEPRECATED);

        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);
        writer.println("Hello, Client!");

        socket.close();
        serverSocket.close();
    }
}