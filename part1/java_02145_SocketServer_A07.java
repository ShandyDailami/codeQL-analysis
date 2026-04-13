import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_02145_SocketServer_A07 {
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER"; // Replace with your client identifier
    private static final String KEYSTORE_LOCATION = "path/to/your/keystore"; // Replace with your keystore location
    private static final String KEYSTORE_PASSWORD = "keystore_password"; // Replace with your keystore password

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, null, null);

            while (true) {
                socket = (SSLSocket) serverSocket.accept();
                socket.setNeedClientAuth(true);
                socket.setClientAuthRequested(true);

                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new File[] {new KeyStore(KEYSTORE_LOCATION, KEYSTORE_PASSWORD).getKeyStoreAlias()}, null);
                socket.setSSLContext(sslContext);

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                    out.writeBytes(line + "\n");
                }

                out.close();
                in.close();
                socket.close();
            }
        } finally {
            serverSocket.close();
        }
    }
}