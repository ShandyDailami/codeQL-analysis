import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_02552_SocketServer_A01 {

    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8888);
        serverSocket.setNeedClientAuth(true);

        SSLContext sslContext = initSSLContext();

        while (true) {
            Socket socket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            System.out.println("Client connected!");

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
                out.write((line + "\n").getBytes());
            }
            socket.close();
        }
    }

    private static SSLContext initSSLContext() throws Exception {
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(new KeyStore[]{loadKeyStore(CLIENT_KEYSTORE, CLIENT_KEYSTORE_PASSWORD)}, null);
        return sslContext;
    }

    private static KeyStore loadKeyStore(String filename, String password) throws Exception {
        FileInputStream fis = new FileInputStream(filename);
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(fis, password.toCharArray());
        return ks;
    }
}