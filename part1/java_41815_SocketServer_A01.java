import java.io.*;
import java.net.*;

public class java_41815_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Verify client's SSL certificate
            SSLSocket sslSocket = (SSLSocket) socket;
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            sslSocket.setNeedClientAuth(true);
            sslSocket.setSSLContext(context);

            // Send welcome message
            out.writeUTF("Secure Connection!");

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            socket.close();
        }
    }

    // Trust all certificates
    static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            return;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            return;
        }
    }
}