import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_19510_SocketServer_A07 {

    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.startHandshake();

                if (clientSocket.getState() == State.CLOSED) {
                    continue;
                }

                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                OutputStream out = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello");

                clientSocket.close();
            }
        } catch (SSLException e) {
            System.out.println("SSLException was caught: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}