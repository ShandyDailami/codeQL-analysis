import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_28878_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 1234;
        ServerSocketFactory ssFactory = null;
        SSLServerSocket sSocket = null;

        try {
            ssFactory = (ServerSocketFactory) SSLServerSocketFactory.getDefault();
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }

        try {
            sSocket = (SSLServerSocket) ssFactory.createServerSocket(port);
            sSocket.setNeedClientAuthentication(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                System.out.println("Waiting for client on port: " + sSocket.getLocalPort());
                sSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}