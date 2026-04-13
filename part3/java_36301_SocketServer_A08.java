import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36301_SocketServer_A08 {
    private static final int PORT = 1234;
    private static Socket socket;
    private static SSLServerSocket serverSocket;
    private static SSLSocket sslSocket;

    public static void main(String[] args) {
        System.out.println("Starting server...");

        try {
            // Setup SSL Server
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("src/main/resources/server.jks"), "password".toCharArray());
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, new java.security.cert.Certificate[]{});

            // Accept Client Connection
            socket = serverSocket.accept();
            sslSocket = (SSLServerSocket) sslContext.getServerSocket();
            System.out.println("Client Connected");

            // Read and write from/to client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send response
            out.write("Hello Client, You are connected to the server!".getBytes());
            out.flush();

            // Close connection
            socket.close();
            sslSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}