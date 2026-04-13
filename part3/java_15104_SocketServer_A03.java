import java.net.*;
import java.io.*;
import java.security.*;
import javax.net.ssl.*;

public class java_15104_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            //Load the SSL certificate and private key
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("sslcertificate.jks"), "password".toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("ssltruststore.jks"), "password".toCharArray());

            //Create a KeyManagerFactory and TrustManagerFactory for the KeyStore
            KeyManagerFactory keyManagerFactory =
                    KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "password".toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);

            //Create a SSLServerSocket and accept client connections
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocket.factory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);

            //Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            //Send a message to the client
            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello Client, you are connected to the Secure Server!");

            //Get a message from the client and echo back
            InputStream in = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Server received: " + line);
                writer.println("Server received: " + line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}