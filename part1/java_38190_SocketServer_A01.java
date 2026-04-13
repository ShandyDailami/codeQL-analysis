import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_38190_SocketServer_A01 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5001);
            serverSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);

            serverSocket.setSSLContext(sslContext);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Receive the request
                String request = in.readUTF();
                System.out.println("Received request: " + request);

                // Send the response
                out.writeUTF("Hello, client!");
                out.flush();

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This is a dummy trust manager that does nothing with certificates
    private static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            return;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            return;
        }
    }
}