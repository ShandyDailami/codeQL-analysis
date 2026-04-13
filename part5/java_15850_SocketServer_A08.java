import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_15850_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("keystore.jks"), "password".toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyStore(keyStore);
            sslServerSocketFactory.setKeyStorePassword("password");

            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);

            while (true) {
                Socket socket = sslServerSocket.accept();

                System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());

                // Create new thread to handle the new connection
                new ClientHandler(socket).start();
            }
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_15850_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Here you can handle your client, for example, read and write data
            InetAddress address = socket.getInetAddress();
            System.out.println("Connection from: " + address);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}