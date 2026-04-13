import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_07437_SocketServer_A01 {

    private final int port;
    private final KeyStore keyStore;
    private final char[] password;

    public java_07437_SocketServer_A01(int port, String keyStorePath, char[] password) throws KeyStoreException, CertificateException, IOException {
        this.port = port;
        this.password = password;

        keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(keyStorePath), password);
    }

    public void start() throws SSLException, IOException {
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            SSLServerSocket secureServerSocket = new SSLServerSocket(clientSocket.getPort(), (SSLServerSocket) clientSocket, keyStore, password);

            InputStream input = secureServerSocket.getInputStream();
            OutputStream output = secureServerSocket.getOutputStream();

            handleClient(input, output, secureServerSocket);
        }
    }

    private void handleClient(InputStream input, OutputStream output, SSLServerSocket serverSocket) throws SSLException, IOException {
        byte[] buffer = new byte[1024];
        int bytesRead = input.read(buffer);

        while (bytesRead != -1) {
            output.write(buffer, 0, bytesRead);
            bytesRead = input.read(buffer);
        }
    }
}