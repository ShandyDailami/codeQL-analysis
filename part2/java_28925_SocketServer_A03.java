import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class java_28925_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        int port = 12345; // default port
        Socket socket = null;

        // Step 1: Set up the SSLServerSocket
        SSLServerSocket serverSocket = null;
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new X509KeyManager[] { new KeyManager() }, null);
        serverSocket = (SSLServerSocket) sslContext.getServerSocket(port);
        serverSocket.setNeedClientAuth(true);

        // Step 2: Accept a client connection
        socket = serverSocket.accept();

        // Step 3: Set up the client socket
        SSLSocket clientSocket = (SSLSocket) socket.createSocket(socket.getInetAddress(), socket.getPort());
        clientSocket.setNeedClientAuth(true);
        clientSocket.startHandshake();

        // Step 4: Communicate with the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            out.println(message);
        }

        // Clean up
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    // A dummy KeyManager for demonstration purposes
    static class KeyManager implements KeyManager {
        public String[] getLocalCertificateAlias(String alias) {
            return new String[] { alias };
        }

        public String getLocalCertificate(String alias) {
            return ""; // Certificate data will be provided by another source
        }

        public void setClientAuth(boolean auth) { }

        public void setServerAuth(boolean auth) { }

        public String[] getSupportedCipherSuites() {
            return new String[] { "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA" };
        }

        public String[] getSupportedClientAuthMethods() {
            return new String[] { "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA" };
        }

        public String[] getSupportedServerAuthMethods() {
            return new String[] { "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA" };
        }
    }
}