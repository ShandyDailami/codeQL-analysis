import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public class java_04003_SocketServer_A03 {

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslsf = getSSLServerSocketFactory();
            serverSocket = (SSLServerSocket) sslsf.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setNeedServerAuth(true);
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            serverSocket.bind(addr);
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client Connected");
                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() {
        SSLServerSocketFactory sslsf = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLSv1.2");
            sc.init(null, null, null); // using default keys
            sslsf = sc.getServerSocketFactory();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
        return sslsf;
    }

    private static class ClientHandler implements Runnable {

        private final SSLSocket clientSocket;

        public java_04003_SocketServer_A03(SSLSocket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Here you can handle the client's data, but for the sake of simplicity, we'll just print the data
            try {
                while ((clientSocket.getInputStream().read()) != -1) {
                    System.out.println("Received: " + clientSocket.getInputStream().read());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}