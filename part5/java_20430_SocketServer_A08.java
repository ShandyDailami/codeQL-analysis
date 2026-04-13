import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.*;

public class java_20430_SocketServer_A08 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        // Load the SSL certificate and key
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("/client.jks"), "password".toCharArray());

        SSLServerSocket serverSocket = new SSLServerSocket(PORT, keyStore, null,
                SSLServerSocket.CipherSuite.TLS_SERVER_AES_WITH_RC4_128_SHA);
        System.out.println("Listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

            // Now we can communicate with the client
            // Create new SSLSocket for the client
            SSLSocket sslSocket = (SSLSocket) clientSocket.createInstance("TLSv1.2", new SSLContext(null));
            sslSocket.setNeedClientAuth(true);
            sslSocket.setReadTimeout(60000);
            sslSocket.setReuseAddress(true);

            // Import client's certificate and use it to authenticate the client
            X509Certificate clientCert = (X509Certificate) sslSocket.getSession().getPeerCertificate();
            sslSocket.setCertificate(clientCert);

            // Create a new thread to handle the communication
            new SocketHandler(sslSocket).start();
        }
    }
}

class SocketHandler extends Thread {
    private final SSLSocket socket;

    public java_20430_SocketServer_A08(SSLSocket socket) {
        this.socket = socket;
    }

    public void run() {
        // Read the data from the client and print it
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}