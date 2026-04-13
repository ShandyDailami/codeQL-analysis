import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_05310_SocketServer_A01 {
    private static SSLServerSocket serverSocket;
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = createServerSocket();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            String message = reader.readLine();
            outputStream.writeUTF("Hello, client, your message was: " + message);

            clientSocket.close();
        }
    }

    private static SSLServerSocket createServerSocket() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
        sslServerSocket.setNeedClientAuth(true);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, null, null);

        sslServerSocket.setSSLSocketFactory(sslContext.getSocketFactory());
        return sslServerSocket;
    }
}