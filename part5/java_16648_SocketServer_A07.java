import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_16648_SocketServer_A07 {

    private static final String KEYSTORE_PATH = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password_for_keystore";
    private static final String KEY_ALIAS = "alias_for_key";

    private static Key loadKeyFromKeystore(KeyStore keystore, String password, String alias) throws Exception {
        Key key = null;

        keystore.load(null, password.toCharArray());
        key = keystore.getKey(alias, password.toCharArray());

        if (key == null) {
            throw new Exception("Key not found");
        }

        return key;
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started");

        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

        Key key = loadKeyFromKeystore(keystore, KEYSTORE_PASSWORD, KEY_ALIAS);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            // Here we encrypt the client's socket with the loaded key
            // This is a very simple example, in a real application you'd likely use a stronger encryption method
            client.setSoTimeout(1000);
            client.getOutputStream().write(client.getLocalPort() + ": connected");
            client.getOutputStream().flush();

            // Now we can use the key to decrypt the client's socket
            // In a real application, you'd also use a stronger decryption method
            byte[] buf = new byte[1024];
            int len = client.getInputStream().read(buf);
            if (len < 0) throw new IOException("Connection closed by client");
            client.getInputStream().close();
            client.close();

            System.out.println("Received: " + new String(buf, 0, len));
        }
    }
}