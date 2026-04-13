import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_24134_SocketServer_A07 {
    private static SSLServerSocket serverSocket;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) throws IOException {
        try {
            SSLServerSocket socket = (SSLServerSocket) new SSLServerSocket(8080);
            socket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() }, null);
            socket.setSSLContext(sslContext);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) socket.accept();
                clientSocket.setNeedClientAuth(true);

                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                // Start receiving data
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    // Send back a response
                    out.writeUTF("Hello, client, you connected!");
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // X509TrustManager implementation
    static class X509TrustManager implements X509TrustManager {
        public java_24134_SocketServer_A07() {
        }

        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
        }

        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}