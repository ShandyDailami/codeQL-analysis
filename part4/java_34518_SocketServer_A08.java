import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_34518_SocketServer_A08 {

    private static SSLServerSocket serverSocket;
    private static Socket socket;
    private static SSLContext sslContext;
    private static SSLSocket sslSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) throws Exception {
        SSLServer();
    }

    public static void SSLServer() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("client.jks"), "password".toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream("truststore.jks"), "password".toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = new SSLServerSocketFactory(keyStore, trustStore, new SSLServerSocket(new SSLSocketFactory(), 8443));
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);

        socket = serverSocket.accept();
        sslSocket = (SSLSocket) socket.createChannel(socket.getChannel().getAccept(serverSocket));
        sslSocket.setNeedClientAuth(true);

        sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(keyStore, trustStore, new java.security.SecureRandom());

        out = new PrintWriter(sslSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

        sslSocket.startHandshake();

        out.println("Hello Client");

        String response = in.readLine();
        System.out.println("Server response: " + response);

        sslSocket.close();
        serverSocket.close();
    }
}