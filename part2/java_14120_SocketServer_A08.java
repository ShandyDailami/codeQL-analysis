import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_14120_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            // Load the server's key and truststore
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            // Accept a connection
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            // Get the SSL input and output streams
            InputStream clientInStream = clientSocket.getInputStream();
            OutputStream clientOutStream = clientSocket.getOutputStream();

            // Create a PrintWriter for the client's output stream
            PrintWriter out = new PrintWriter(clientOutStream, true);

            // Send a welcome message
            out.println("Welcome to the server! Please enter your username:");

            // Read the username
            BufferedReader in = new BufferedReader(new InputStreamReader(clientInStream));
            String username = in.readLine();

            // Encrypt and send the username back to the client
            String encryptedUsername = encryptAndSend(username, clientOutStream);

            // Receive the encrypted username from the client
            String receivedUsername = in.readLine();

            // Verify the encrypted username
            if (receivedUsername.equals(encryptedUsername)) {
                System.out.println("Username verification successful!");
            } else {
                System.out.println("Verification failed!");
            }

            // Close the connection
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static String encryptAndSend(String username, OutputStream out) throws IOException {
        // Load the server's key and truststore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKeyManagerFactory");
        keyManagerFactory.init(keyStore, "password".toCharArray());

        // Set up the SSLSocketFactory with the key manager
        SSLSocketFactory sslSocketFactory = sslSocketFactoryWithKeyManager(keyManagerFactory);

        // Create a new SSLSocket
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 8080);

        // Send the username
        out.println(username);

        // Close the connection
        sslSocket.close();

        return username;
    }

    private static SSLSocketFactory sslSocketFactoryWithKeyManager(KeyManagerFactory keyManagerFactory) throws IOException {
        SSLSocketFactory sslSocketFactory = SSLSocketFactory.getDefault();
        SSLServerSocket sslsock = (SSLServerSocket) sslSocketFactory.createServerSocket(8080);
        sslsock.setNeedClientAuth(true);
        KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
        sslsock.setKeyManagers(keyManagers);
        return sslsock;
    }
}