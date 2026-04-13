import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_04414_SocketServer_A07 {

    private static SSLServerSocket serverSocket;
    private static DataInputStream dis;
    private static DataOutputStream dos;

    public static void main(String[] args) throws Exception {

        SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();

        serverSocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(8001);
        serverSocket.setNeedClientAuth(true);

        SSLContext sslcontext = SSLContext.getInstance("SSL");
        sslcontext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
        serverSocket.setSSLContext(sslcontext);

        System.out.println("Waiting for client on port: " + serverSocket.getPort());

        Socket client = serverSocket.accept();
        System.out.println("Client accepted");

        // Create InputStream and OutputStream
        dis = new DataInputStream(client.getInputStream());
        dos = new DataOutputStream(client.getOutputStream());

        // Send response
        dos.writeUTF("Hello Client, You are authenticated!");

        // Close connections
        dos.close();
        dis.close();
        client.close();
        serverSocket.close();
    }

    // This is a TrustManager that trusts all SSL certificates
    class TrustAllCerts extends SSLCertificateTrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
            //nothing to do
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) {
            //nothing to do
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}