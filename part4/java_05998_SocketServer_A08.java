import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_05998_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        ServerSocket server = null;
        SSLServerSocket sslServer = null;

        try {
            // Create a server socket
            server = new ServerSocket(PORT);

            // Generate a KeyStore and TrustStore and configure SSLContext
            SSLServerSocket sslServerSocket = (SSLServerSocket) server;
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() }, null);
            sslServer = (SSLServerSocket) sslContext.getServerSocketSocket();

            System.out.println("Waiting for client on port " + PORT);

            // Accept client connection
            Socket socket = sslServer.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send response
            out.println("Hello, client!");

            // Close connections
            in.close();
            out.close();
            socket.close();
            sslServerSocket.close();
            server.close();
            sslContext.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}