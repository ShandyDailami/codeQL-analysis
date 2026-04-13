import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41293_SocketServer_A07 {
    private static final String CLIENT_IDENTIFICATION = "CLIENT_IDENTIFICATION";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] {new TrustAllCertsTrustManager()}, null);
            serverSocket.setSSLSocketFactory(sslContext.getSocketFactory());

            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

                String clientMsg = in.readLine();
                System.out.println("Received: " + clientMsg);

                if (clientMsg.equals(CLIENT_IDENTIFICATION)) {
                    out.println("Server accepted the client's identification.");
                } else {
                    out.println("Client's identification failed.");
                }
                out.flush();
            }
        } finally {
            serverSocket.close();
        }
    }

    static class TrustAllCertsTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            return;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            return;
        }
    }
}