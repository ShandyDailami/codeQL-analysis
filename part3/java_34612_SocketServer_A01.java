import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_34612_SocketServer_A01 {
    private static final String SERVER_KEYSTORE_PATH = "server.jks";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String CLIENT_KEYSTORE_PATH = "client.jks";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);
        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;

        sslServerSocket.setNeedClientAuthentication(true);
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(CLIENT_KEYSTORE_PATH), CLIENT_KEYSTORE_PASSWORD.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(keyStore, null, new ArrayList<PasswordCallback>());

        Socket socket = sslServerSocket.accept();
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            out.println(message);
        }
    }
}