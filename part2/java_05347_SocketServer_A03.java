import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05347_SocketServer_A03 {

    private static SSLServerSocket serverSocket;
    private static SSLSocket socket;

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Load the certificate and private key
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, null);
            serverSocket.setSSLContext(sslContext);

            System.out.println("Server is listening on port 8080");
            socket = (SSLSocket) serverSocket.accept();

            System.out.println("Client connected");

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (true) {
                String message = reader.readLine();
                System.out.println("Received: " + message);
           
                // Here you can add the code for the server's response

                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Server received the message");
            }
        } catch (SSLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TrustAnyTrustManager is a trust manager that trusts all certificates
    private static class TrustAnyTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) { }
        public void checkServerTrusted(X509Certificate[] certs, String authType) { }
    }
}