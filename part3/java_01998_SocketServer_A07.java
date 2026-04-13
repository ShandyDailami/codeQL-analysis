import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import javax.crypto.*;
import javax.crypto.spec.SSLServerKeySpec;
import java.security.*;

public class java_01998_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String ALIAS = "your_alias";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) throws Exception {
        // Load the keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        // Get the private key associated with the alias
        Key key = keyStore.getKey(ALIAS, KEY_PASSWORD.toCharArray());

        // Create a SSLServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(keyStore, new SSLServerSocket(new File("/dev/null")));

        // Accept client connections
        Socket client = sslServerSocket.accept();

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // Send a welcome message
        out.println("Welcome to the secure server!");

        // Handle client requests
        String request;
        while ((request = in.readLine()) != null) {
            out.println("Server received: " + request);
            out.flush();
        }

        // Close the connection
        client.close();
        sslServerSocket.close();
    }
}