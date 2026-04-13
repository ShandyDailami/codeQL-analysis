import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_04023_SocketServer_A07 {
    private int port;
    private SSLServerSocket serverSocket;

    public java_04023_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() {
        try {
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuthentication(true);
            serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());

            System.out.println("Waiting for client on port: " + port);
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client accepted!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                out.println("Hello, client!");
            }

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(8080);
        server.start();
    }
}