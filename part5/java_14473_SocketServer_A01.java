import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_14473_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        // Load server's keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        // Load client's truststore
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream("client.jks"), "password".toCharArray());

        // Create SSLContext that uses our keyStore and trustStore
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, trustStore, null);

        // Setup SSLServerSocket
        serverSocket = (SSLServerSocket) sslContext.getServerSocket(3000);

        while (true) {
            clientSocket = serverSocket.accept();

            // Create input and output streams
            OutputStream outToClient = clientSocket.getOutputStream();
            InputStream inFromClient = clientSocket.getInputStream();

            // Send the request to the client
            outToClient.write("Hello client, I am secure server!".getBytes());
            outToClient.close();

            // Read the response from the client
            byte[] msg = new byte[256];
            int bytesRead = inFromClient.read(msg);
            String response = new String(msg, 0, bytesRead);
            System.out.println("Server says: " + response);

            clientSocket.close();
        }
    }
}