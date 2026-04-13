import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_31730_SocketServer_A01 {
    private static SSLServerSocket serverSocket;
    private static DataInputStream dis;
    private static DataOutputStream dos;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setNeedClientAuthentication(true);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, new java.security.SecureRandom());

        SSLServerSocket socket = (SSLServerSocket) sslContext.getServerSocket(serverSocket);

        Socket clientSocket = socket.accept();
        SSLSocket sslSocket = (SSLSocket) clientSocket.getChannel().newChannel();
        sslSocket.setNeedClientAuthentication(true);

        dis = new DataInputStream(sslSocket.getInputStream());
        dos = new DataOutputStream(sslSocket.getOutputStream());

        String message = dis.readUTF();
        System.out.println("Client says: " + message);

        dos.writeUTF("Hello, Client!");
        sslSocket.close();
    }

    static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) { }
        public void checkServerTrusted(X509Certificate[] certs, String authType) { }
    }
}