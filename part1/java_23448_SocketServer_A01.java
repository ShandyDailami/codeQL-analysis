import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_23448_SocketServer_A01 {

    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";

    public static void main(String[] args) throws IOException {

        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
        sslServerSocket.setSSLContext(sslContext);

        Socket socket = sslServerSocket.accept();
        SSLSocket sslSocket = (SSLSocket) socket.getUnderlyingSocket();

        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);

            if (message.equals("exit")) {
                out.println("Goodbye!");
                break;
            } else {
                out.println("Hello, client!");
            }
        }

        sslSocket.close();
        socket.close();
    }

    static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {}

        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
    }
}