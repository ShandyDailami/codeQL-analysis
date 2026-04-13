import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_41197_SocketServer_A01 {
    private static final String CLIENT_CERT_PATH = "client.crt"; // Path to client certificate
    private static final String KEY_STORE_PATH = "keystore.jks"; // Path to key store file

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, null, null, null);
            serverSocket.setNeedClientAuthentication(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEY_STORE_PATH), "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);
            serverSocket.setSSLSocketFactory(sslContext.getSocketFactory());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket socket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();

            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = sslSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            String clientMessage = reader.readLine();
            System.out.println("Received client message: " + clientMessage);

            if (clientMessage.equals("BROKEN")) {
                // Broken Access Control: Allow client to bypass authentication
                writer.println("ACCESS GRANTED");
            } else {
                // Authentication failed
                writer.println("ACCESS DENIED");
            }
        }
    }
}