import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_08245_SocketServer_A01 {
    private static final String PASSWORD = "securepassword"; // Hardcoded for simplicity

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4445);
            sslServerSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, new TrustManager[]{new TrustAllCerts()}, new java.security.SecureRandom());
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setUseClientMode(true);
            sslServerSocket.setSSLEngine(sslContext.getSSLEngine());
        } catch (SSLException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            Socket socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            String clientMessage = in.readLine();
            System.out.println("Client says: " + clientMessage);

            if (clientMessage.equals("exit")) {
                break;
            }

            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());
            out.writeUTF("Server says: Hello, Client");
            out.flush();
        }

        sslServerSocket.close();
        serverSocket.close();
    }

    static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }
}