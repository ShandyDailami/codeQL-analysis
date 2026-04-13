import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import javax.security.auth.*;
import javax.security.auth.message.AuthException;

public class java_32112_SocketServer_A07 {

    private static SSLServerSocket serverSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) {
        int port = 8888;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] {new TrustAllCertificates()}, null);
            serverSocket.setSSLContext(sslContext);

            System.out.println("Waiting for client connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send welcome message
            outToClient.println("Welcome!");
            outToClient.flush();

            String clientInput;

            while ((clientInput = inFromClient.readLine()) != null) {
                System.out.println("Received: " + clientInput);
                // Process the input
            }

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SSLException e) {
            e.printStackTrace();
        }
    }

    private static class TrustAllCertificates implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            return;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            return;
        }
    }
}