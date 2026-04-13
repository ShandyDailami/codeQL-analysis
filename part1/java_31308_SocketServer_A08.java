import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_31308_SocketServer_A08 {
    private static final String CLIENT_MSG = "Client connected";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            // Setup server socket
            serverSocket = new ServerSocket(8080);

            // Generate SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            sslServerSocket = (SSLServerSocket) sslContext.getServerSocketFactory().createServerSocket(8080);

            System.out.println("Waiting for client...");

            // Accept client connection
            socket = sslServerSocket.accept();
            System.out.println("Client connected");

            // Send client message
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(CLIENT_MSG);
            System.out.println("Server says: " + socket.getInputStream().readUTF());

            // Close connections
            socket.close();
            sslServerSocket.close();
            serverSocket.close();
        } finally {
            // Close all resources
            if (socket != null) socket.close();
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }

    // Trust all certs
    static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) {}
        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
    }
}