import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_04878_SocketServer_A08 {

    private final int port;
    private SSLServerSocket sslServerSocket;

    public java_04878_SocketServer_A08(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

        System.out.println("Server started on port: " + port);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("Client connected");

            // Perform SSL encryption and authentication
            sslSocket.startHandshake();

            // Perform SSL decryption
            DataInputStream in = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Hello, Client");
            out.flush();

            sslSocket.close();
       
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(8080).start();
    }
}