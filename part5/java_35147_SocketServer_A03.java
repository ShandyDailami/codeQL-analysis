import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_35147_SocketServer_A03 {

    public static void main(String[] args) throws IOException, CertificateException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080)) {
            sslServerSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            try (InputStream keyStoreInputStream = getClass().getResourceAsStream("/keystore.jks")) {
                keyStore.load(keyStoreInputStream, "mypassword".toCharArray());
            }

            sslServerSocket.setKeyStore(keyStore);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);

                try (InputStream inputStream = sslSocket.getInputStream();
                     OutputStream outputStream = sslSocket.getOutputStream()) {

                    // handle client requests here
                    byte[] buffer = new byte[1024];
                    int bytesRead = inputStream.read(buffer);
                    if (bytesRead < 0) {
                        break;
                    }
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        }
    }
}