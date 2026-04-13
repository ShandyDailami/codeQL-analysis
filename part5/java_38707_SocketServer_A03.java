import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_38707_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(12345);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
            sslServerSocket.setNeedClientAuthentication(true);
            sslServerSocket.setContext(sslContext);

            System.out.println("Waiting for client connection...");
            Socket socket = sslServerSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String messageFromClient;
            while ((messageFromClient = in.readLine()) != null) {
                System.out.println("Received: " + messageFromClient);
                out.writeBytes(messageFromClient + "\r\n");
            }

            socket.close();
            sslServerSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class TrustAnyTrustManager implements X509TrustManager {
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