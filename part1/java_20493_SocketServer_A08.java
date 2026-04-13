import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_20493_SocketServer_A08 {

    private static final String CLIENT_CERT = "client.cert";
    private static final String CLIENT_KEY = "client.key";

    public static void main(String[] args) {
        try {
            SSLServerSocket serverSocket = null;
            try {
                serverSocket = (SSLServerSocket) new SSLServerSocket(4444,
                        SSLServerSocket.CERT_NONE, null, InetAddress.getByName("localhost"));
            } catch (IOException e) {
                System.err.println("Could not listen on port 4444");
                System.exit(-1);
            }

            while (true) {
                try {
                    SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                    System.out.println("Accepted connection from "
                            + clientSocket.getInetAddress().getHostAddress());
                    Thread thread = new Thread(new SocketHandler(clientSocket));
                    thread.start();
                } catch (SocketException e) {
                    clientSocket.close();
                    System.err.println("Accept failed on port 4444: " + e);
                    System.exit(-1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;
        private final SSLSocketFactory sslSocketFactory;

        public java_20493_SocketServer_A08(Socket socket) {
            this.socket = socket;
            sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }

        @Override
        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(socket,
                        socket.getInetAddress(), socket.getLocalPort(), true);
                sslSocket.setNeedClientAuth(true);

                sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

                sslSocket.setCertificateChain(CLIENT_CERT);
                sslSocket.setPrivateKey(CLIENT_KEY);

                // Start the communication
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}