import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_23834_SocketServer_A03 {
    private static final int PORT = 4445;
    private static SSLServerSocket serverSocket;
    private static Socket socket;
    private static SSLContext sslContext;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            socket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInputStream(), socket.getOutputStream());
            sslSocket.startHandshake();

            SSLSession sslSession = sslSocket.getSession();
            // Check if it's secure and print out information about the session.
            if (sslSession.isSecure()) {
                System.out.println("Secure Connection");
                System.out.println("Session ID: " + sslSession.getId());
            }

            // Close the socket and print out a message.
            sslSocket.close();
            System.out.println("Client disconnected: " + sslSession.getRemoteSocketAddress());
        }
    }
}