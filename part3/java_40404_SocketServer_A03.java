import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_40404_SocketServer_A03 {
    private final int port;
    private SSLServerSocket sslServerSocket;

    public java_40404_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAllCertsTrustManager()}, new java.security.SecureRandom());
            sslServerSocket.setSSLContext(sslContext);

            while (true) {
                Socket socket = sslServerSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                out.writeUTF("Hello, client, your message was: " + message);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer(8000).start();
    }

    static class TrustAllCertsTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isTrusted(X509Certificate[] chain) {
            return true;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            return;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            return;
        }
    }
}