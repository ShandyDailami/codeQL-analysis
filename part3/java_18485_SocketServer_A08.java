import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_18485_SocketServer_A08 {

    private static SSLServerSocket sslServerSocket;
    private static Socket sslSocket;

    public static void main(String[] args) {
        try {
            trustAllHosts();
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            sslServerSocket = serverSocket;
            while (true) {
                sslSocket = sslServerSocket.accept();
                SSLSocket clientSocket = (SSLSocket) sslSocket.getSocket();
                System.out.println("New client connected");
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                String message = in.readUTF();
                System.out.println("Received: " + message);
                out.writeUTF("Thank you for connecting");
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void trustAllHosts() {
        try {
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("truststore.jks"), "truststorepassword".toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(trustStore, "truststorepassword".toCharArray());
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory, null, null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        } catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}