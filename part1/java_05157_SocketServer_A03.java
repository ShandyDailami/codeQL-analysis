import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_05157_SocketServer_A03 {
    private static final String CLIENT_KEY_STORE = "client.jks";
    private static final String CLIENT_KEY_STORE_PASSWORD = "password";
    private static final String KEY_PASSWORD = "password";
    private static final String SSL_PROTOCOL = "SSLv3";

    public static void main(String[] args) throws Exception {
        ServerSocketFactory ssFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        int port = 7000;

        SSLServerSocket sslServerSocket = (SSLServerSocket) ssFactory.createServerSocket(port);
        sslServerSocket.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCOL);
        sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);
        sslServerSocket.setSSLContext(sslContext);

        Socket socket = null;
        try {
            socket = sslServerSocket.accept();
            System.out.println("Client connected");

            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setNeedClientAuth(true);

            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Server received: " + message);
                if (message.equals("close")) {
                    socket.close();
                }
            }
        } finally {
            socket.close();
        }
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }
}