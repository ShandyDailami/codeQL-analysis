import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32882_SocketServer_A03 {
    private static final String CLIENT_IDENTIFIER = "SSLClient";
    private SSLServerSocket serverSocket;

    public java_32882_SocketServer_A03(int port) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuth(true);
        } catch (SSLException e) {
            System.out.println("Error setting up SSL");
            e.printStackTrace();
        }
    }

    public void startServer() {
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Socket client = serverSocket.accept();
                        System.out.println("Client accepted");

                        // Perform authentication
                        SSLSession sslSession = client.getSSLSession();
                        sslSession.setClientCertificates(client.getServerSignedCertificates());
                        sslSession.setClientAuth(SSLSession.GET_CLIENT_AUTH);
                        sslSession.checkUserInteraction();

                        // Perform further operations here

                    } catch (IOException e) {
                        System.out.println("Error processing client connection");
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    public static void main(String[] args) {
        new SecureSocketServer(4445).startServer();
    }
}