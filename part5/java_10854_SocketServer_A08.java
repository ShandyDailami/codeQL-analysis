import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_10854_SocketServer_A08 {
    private static final String CERTIFICATE_PATH = "path_to_your_certificate.pem";
    private static final String KEY_PATH = "path_to_your_key.pem";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);

            while (true) {
                socket = serverSocket.accept();

                System.out.println("Connection established!");

                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getChannel().getLocalAddress());
                sslSocket.setNeedClientAuthentication(true);

                SSLCertificate cert = new SSLCertificate(CERTIFICATE_PATH);
                KeyStore ks = new KeyStore(KEY_PATH, "password".toCharArray());
                KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKS");
                kmf.init(ks, "password".toCharArray());
                sslSocket.setKeyManagers(kmf.getKeyManagers());
                sslSocket.setTrustManagers(kmf.getTrustManagers());

                sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

                SSLPeerConnection pc = SSLPeerConnection.create(sslSocket);
                SSLSession ss = pc.getSession();
                ss.setCipherSuites(new String[]{"TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"});

                OutputStream out = sslSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello, client!");

                SSLCertificate clientCert = pc.getPeerCertificate();
                System.out.println("Client certificate: " + clientCert.toString());

                sslSocket.close();
            }
        } finally {
            serverSocket.close();
        }
    }
}