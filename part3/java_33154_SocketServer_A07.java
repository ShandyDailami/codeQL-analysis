import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_33154_SocketServer_A07 {
    private static final String KEYSTORE_PATH = "path_to_your_keystore";
    private static final String KEYSTORE_PWD = "password_of_keystore";
    private static final String KEY_ALIAS = "alias_of_key";

    public static void main(String[] args) {
        try (KeyStore keyStore = KeyStore.getInstance("JKS")) {
            keyStore.load(SecureSocketServer.class.getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PWD.toCharArray());

            SSSFServerSocketFactory sssf = new SSSFServerSocketFactory(keyStore, KEY_ALIAS);

            try (ServerSocket serverSocket = sssf.createServerSocket(8080)) {
                while (true) {
                    Socket socket = serverSocket.accept();
                    new ServerThread(socket).start();
                }
            }
        } catch (IOException | KeyStoreException | CertificateException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private final Socket socket;

    public java_33154_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
    }
}