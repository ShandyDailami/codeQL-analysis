import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_15701_SocketServer_A03 {

    private static final String CLIENT_MESSAGE = "Hello from server!";
    private static final String SERVER_MESSAGE = "Server received your message!";
    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            serverSocket.setSSLContext(sslContext);
            System.out.println("Server SSL enabled");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getRemoteSocketAddress());
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    out.println(SERVER_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // Not used
        }
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // Not used
        }
    }
}