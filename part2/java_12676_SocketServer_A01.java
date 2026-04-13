import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_12676_SocketServer_A01 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;
        SSLContext context = SSLContext.getInstance("SSL");

        // Load the SSL certificates
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        keyStore.setPassword(null); // required to access the key store

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) serverSocket.getSSLServerSocketFactory();

        // Initialize the context with the key store and password
        context.init(keyStore, null, null);

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        while (true) {
            socket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected!");

            // Send a response to the client
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello Client, You are connected to the server!");

            // Close the connection
            socket.close();
       
            // End the program
            System.exit(1);
        }
    }
}