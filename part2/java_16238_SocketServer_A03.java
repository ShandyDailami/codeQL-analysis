import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_16238_SocketServer_A03 {
    public static void main(String[] args) throws CertificateException, KeyStoreException, IOException {
        // Create a key store and add a certificate to it
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SecureSocketServer.class.getResourceAsStream("/server.jks"), "password".toCharArray());

        // Create a server socket with SSL
        ServerSocket serverSocket = new ServerSocket(12345, keyStore, "TLSv1.2", true);
        serverSocket.setReuseAddress(true);

        // Accept a client connection and create a new socket for it
        Socket clientSocket = serverSocket.accept();

        // Close the server socket and create a new socket for the client
        serverSocket.close();
        Socket clientSocket2 = new Socket(clientSocket.getInetAddress(), 12345);

        // Write a message to the client
        clientSocket2.getOutputStream().write("Hello, client!".getBytes());

        // Read a response from the client
        byte[] bytes = new byte[256];
        clientSocket2.getInputStream().read(bytes);
        System.out.println("Server: " + new String(bytes));

        // Close the client socket
        clientSocket2.close();
    }
}