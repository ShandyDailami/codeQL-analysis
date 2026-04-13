import java.net.*;
import java.io.*;
import javax.net.ssl.*;
import javax.sound.sampled.*;

public class java_08912_SocketServer_A08 {
    private static final String CLIENT_CERT_PATH = "client.cert";

    public static void main(String[] args) throws Exception {
        ServerSocketFactory ssf = (String arg0, int arg1, int arg2,
                                              InetAddress arg3, int arg4,
                                              SocketOptions arg5) -> new SecureServerSocket(arg1, arg2, arg3, arg4, arg5);
        SSLServerSocket sslServerSocket = null;

        try {
            SSLServerSocket sslServer = (SSLServerSocket) ssf.createServerSocket(8080, 10, null, (cert, trust) -> {
                SSLServerSocket socket = (SSLServerSocket) sslServer;
                socket.setNeedClientAuth(true);
                socket.setCertificateExtensions(new String[] {
                    SSL_DEFAULT_CIPHERSUITES
                });

                FileInputStream certIn = new FileInputStream(CLIENT_CERT_PATH);
                KeyStore keyStore = KeyStore.getInstance("JKS");
                keyStore.load(certIn, "password".toCharArray());
                certIn.close();

                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, "password".toCharArray());

                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);

                return new SSLServerSocket(socket, keyManagerFactory, trustManagerFactory);
            });

            sslServerSocket = (SSLServerSocket) sslServer;

            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Client connected");

                SSLSocket sslSocket = (SSLSocket) socket.createChannel(SocketBufferFactory.getDefault());
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();

                SSLCertificate cert = sslSocket.getCertificate();
                System.out.println("Client certificate: " + cert.toString());

                InputStream in = sslSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                }

                sslSocket.close();
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}