import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_00034_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;

        try {
            socket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            // Create SSL Server Socket
            sslSocket = (SSLServerSocket) socket.accept();
            sslSocket.accept();

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] {new TrustAllCerts()}, null);

            SSLSocket sslSock = (SSLSocket) sslContext.getSocket(sslSocket);
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSock.getInputStream()));
            PrintWriter out = new PrintWriter(sslSock.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Thank you for connecting, " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
            sslSocket.close();
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