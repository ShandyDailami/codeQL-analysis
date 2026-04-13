import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class java_34248_SocketServer_A03 {

    // The port on which the server will listen
    private static final int PORT = 4433;

    public static void main(String[] args) throws Exception {

        // Set up SSL context
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuthentication(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("path_to_your_keystore.jks"), "your_password".toCharArray());

            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;
            sslServerSocket.setKeyStore(keyStore);
            sslServerSocket.setNeedClientAuthentication(true);

            // Create the SSLContext using the keyStore and trustStore
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, new java.security.SecureRandom());

            System.out.println("Server started!");
            while (true) {
                // Wait for client connection
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

                System.out.println("Client connected!");

                // Create input and output streams
                OutputStream out = clientSocket.getOutputStream();
                InputStream in = clientSocket.getInputStream();

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(in, out));
                thread.start();
            }
        } finally {
            serverSocket.close();
        }
    }
}

class ClientHandler implements Runnable {

    private InputStream in;
    private OutputStream out;

    public java_34248_SocketServer_A03(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            // Read from the client
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                // Echo back to client
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}