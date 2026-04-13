import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_15409_SocketServer_A03 {
    private static SSLServerSocket serverSocket;
    private static BufferedReader in = null;
    private static DataOutputStream out = null;

    public static void main(String[] args) throws Exception {
        System.out.println("Starting server...");

        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444);
        sslServerSocket.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, new java.security.SecureRandom());
        sslServerSocket.setSSLContext(sslContext);

        serverSocket = sslServerSocket;

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());

            String request = in.readLine();
            System.out.println("Received: " + request);

            if (request.equals("exit")) {
                break;
            }

            out.writeBytes("Hello, Client\n");
            out.flush();
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // trust all
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // trust all
        }
    }
}