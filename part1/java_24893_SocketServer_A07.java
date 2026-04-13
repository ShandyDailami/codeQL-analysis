import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_24893_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 7000;
        boolean stop = false;

        try {
            SSLServerSocket serverSocket = null;
            SSLSocket clientSocket = null;

            // load trusted certificates
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("path_to_your_keystore"), "keystore_password".toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("path_to_your_truststore"), "truststore_password".toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = new SSLServerSocketFactory(keyStore, "SSL".toCharArray(),
                    new SSLServerSocketFactory().getDefaultHostnamesAccepted(), new SSLServerSocketFactory().getSupportedProtocols());

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setEnabledSSL(true);

            while (!stop) {
                clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

                System.out.println("Connected to client");
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received from client: " + clientMessage);

                    if (clientMessage.equals("exit")) {
                        stop = true;
                        break;
                    }

                    PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
                    out.println("Hello client, you've connected successfully.");
                }
           
                clientSocket.close();
            }

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}