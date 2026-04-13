import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_35615_SocketServer_A07 {

    private static SSLServerSocket serverSocket;
    private static SSLSocket clientSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) {
        try {
            // Set up the SSL context.
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            serverSocket.setSSLContext(sslContext);

            System.out.println("Server started.");

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client accepted.");

                inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

                // Send a greeting message to the client.
                outToClient.println("Hello, Client!");
                outToClient.flush();

                // Receive the client's message.
                String message = inFromClient.readLine();
                System.out.println("Message from client: " + message);

                clientSocket.close();
            }
        } catch (SSLException e) {
            e.printStackTrace();
        }
    }

    // Inner class to allow the server socket to accept any client.
    private static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            return;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            return;
        }
    }
}