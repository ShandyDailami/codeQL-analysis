import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_38197_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Set up a SSLServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8443);

        // Create a new SSLContext and use it to get a new SSLSocket
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] {new TrustAllCertificatesTrustManager()}, null);
        SSLServerSocket socket = (SSLServerSocket) sslContext.getServerSocket(sslServerSocket);

        // Block until a client connects
        Socket client = socket.accept();

        // Get the input and output streams
        SSLSocket sslSocket = (SSLSocket) client.getSocket();
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

        // Send a greeting to the client
        out.println("Hello, Client!");

        // Wait for a line of text
        String message = in.readLine();
        System.out.println("Server says: " + message);

        // Close the socket and server
        sslSocket.close();
        socket.close();
    }

    // Trust all certificates
    static class TrustAllCertificatesTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isClientTrusted(X509Certificate[] certs) {
            return true;
        }

        public boolean isServerTrusted(X509Certificate[] certs) {
            return true;
        }

        public void validateClient(X509Certificate cert) {
        }

        public void validateServer(X509Certificate cert) {
        }
    }
}