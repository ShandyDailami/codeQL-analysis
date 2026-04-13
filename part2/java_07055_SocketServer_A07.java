import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_07055_SocketServer_A07 {
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String ALTERNATE_NAME = "localhost";
    private static final String SSL_PROTOCOL = "SSL";

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            KeyStore clientKeystore = KeyStore.getInstance("JKS");
            clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());

            KeyStore serverKeystore = KeyStore.getInstance("JKS");
            serverKeystore.load(new FileInputStream(SERVER_KEYSTORE), SERVER_KEYSTORE_PASSWORD.toCharArray());

            TrustStore trustStore = null;

            try {
                trustStore = new KeyStore("src/main/resources/truststore", "truststore".toCharArray());
            } catch (IOException e) {
                e.printStackTrace();
            }

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) serverSocket.getSSLServerSocketFactory();
            SSLSocketFactory sslSocketFactory = sslServerSocketFactory.getSocketFactory();

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                clientSocket = (SSLSocket) sslSocketFactory.createSocket(serverSocket.getInetAddress(), serverSocket.getPort());
                OutputStream outToClient = clientSocket.getOutputStream();
                InputStream inFromClient = clientSocket.getInputStream();

                DataOutputStream out = new DataOutputStream(outToClient);
                DataInputStream in = new DataInputStream(inFromClient);

                // Send the client a welcome message
                out.writeUTF("Welcome to the server!");

                // Receive the server a message
                String serverMessage = in.readUTF();
                System.out.println("Server says: " + serverMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}