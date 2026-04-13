import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_28667_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            InputStream inputStream = SocketServer.class.getResourceAsStream("/client.jks");
            keyStore.load(inputStream, "password".toCharArray());
            
            KeyManager[] keyManagers = new KeyManager[]{
                new KeyManager() {
                    @Override
                    public Key getKey() {
                        return keyStore.getKey("alias", "password".toCharArray());
                    }

                    @Override
                    public String getTransferPassword() {
                        return "password".toCharArray()[0] + "";
                    }

                    @Override
                    public void startHandshake() {}
                    @Override
                    public void endHandshake() {}
                }
            };
            
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, keyStore, keyManagers);
            
            Socket socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket;
            sslSocket.setNeedClientAuth(true);

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Message received: " + message);

            String response = "Hello, client!";
            outputStream.write(response.getBytes());

            sslSocket.close();
            sslServerSocket.close();

        } catch (KeyManagementException | CertificateException | IOException e) {
            e.printStackTrace();
        }
    }
}