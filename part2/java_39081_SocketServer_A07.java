import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import javax.security.auth.callback.*;

public class java_39081_SocketServer_A07 {
    private static final String CERT_PATH = "/path/to/your/cert.pem";
    private static final String KEYSTORE_PATH = "/path/to/your/keystore.pem";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = new SSLServerSocket(8443, null, new SSLServerSocketFactory(createKeyStore(), null), SSLServerSocketFactory.DEFAULT_MAX_PROXY_SSL_SESSION_IDLE_TIME);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) clientSocket.getRealSocket();
            sslSocket.setNeedClientAuth(true);
            sslSocket.setUseClientMode(true);

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

            // Send server certificate
            out.println("-----BEGIN CERTIFICATE-----");
            readAndPrintCertificate(new FileInputStream(CERT_PATH));
            out.println("-----END CERTIFICATE-----");

            // Read and send authentication request
            String message = in.readLine();
            out.println("Server said: " + message);

            // Handle authentication
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("client", "password".toCharArray());
                }
            };
            sslSocket.setPasswordAuthenticator(auth);
            sslSocket.startHandshake();

            // Handle communication
            String response = in.readLine();
            out.println("Client said: " + response);
            out.close();
            in.close();
            sslSocket.close();
            clientSocket.close();
        }
    }

    private static KeyStore createKeyStore() throws Exception {
        char[] password = "password".toCharArray();
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(KEYSTORE_PATH), password);
        return ks;
    }

    private static void readAndPrintCertificate(FileInputStream fis) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}