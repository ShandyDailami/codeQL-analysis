import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_30373_SocketServer_A03 {
    private static final String CLIENT_IDENTIFIER = "SSLServer";
    private static final SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = (ServerSocket) SSLServerSocket.createServerSocket(10000, 10, null, createKeyStore());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                handleClient(sslSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleClient(SSLSocket sslSocket) throws IOException {
        InetAddress clientAddress = sslSocket.getInetAddress();
        System.out.println("Client " + clientAddress + " connected");

        InputStream in = sslSocket.getInputStream();
        OutputStream out = sslSocket.getOutputStream();

        byte[] b = new byte[1024];
        int length;
        while ((length = in.read(b)) != -1) {
            System.out.println(new String(b, 0, length));
            out.write(b, 0, length);
        }

        sslSocket.close();
        System.out.println("Client " + clientAddress + " disconnected");
    }

    private static KeyStore createKeyStore() throws IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] password = "password".toCharArray();
        keyStore.load(new FileInputStream("server.jks"), password);
        return keyStore;
    }
}