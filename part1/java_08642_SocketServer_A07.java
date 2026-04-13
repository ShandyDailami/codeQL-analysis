import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_08642_SocketServer_A07 {

    private final int port;
    private SSLServerSocket serverSocket;

    public java_08642_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        serverSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client authentication...");
        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        System.out.println("Client authenticated successfully!");
        clientSocket.close();
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8080);
        server.start();
        server.stop();
    }
}