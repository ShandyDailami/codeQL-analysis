import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_12839_SocketServer_A03 {

    public static void main(String[] args) throws IOException, CertificateException {
        // Create a keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);

        // Create a server socket with SSL
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

        // Use the key store
        sslServerSocket.setEnabledKeystorePasswords(new String[] {"password"});
        sslServerSocket.setNeedClientAuth(true);

        // Set the client authentication callback
        sslServerSocket.setNeedClientAuthentication(true);
        sslServerSocket.setAuthRequested(true);

        // Accept a client connection
        Socket socket = sslServerSocket.accept();
        SSLSocket sslSocket = (SSLSocket) socket;

        // Read data from the client
        DataInputStream input = new DataInputStream(sslSocket.getInputStream());
        System.out.println(input.readUTF());

        // Write data to the client
        DataOutputStream output = new DataOutputStream(sslSocket.getOutputStream());
        output.writeUTF("Hello, client!");
        output.flush();

        // Close the connection
        sslSocket.close();
    }
}