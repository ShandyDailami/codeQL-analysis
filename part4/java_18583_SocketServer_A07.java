import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_18583_SocketServer_A07 {

    private static final String CLIENT_CERT = "path_to_your_client_cert";
    private static final String CLIENT_KEY = "path_to_your_client_key";
    private static final String CA_CERT = "path_to_your_ca_cert";

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyStorePath(CLIENT_KEY);
            sslServerSocketFactory.setKeyStorePassword("password");
            sslServerSocketFactory.setKeyStoreType("PKCS12");
            sslServerSocketFactory.setCipherSuites(new String[]{"SSL_RSA_WITH_AES_128_CBC_SHA", "SSL_DSS_WITH_AES_128_CBC_SHA", "SSL_RSA_WITH_AES_256_CBC_SHA"});
            sslServerSocketFactory.setProtocols(new String[]{SSLSocket.DEFAULT_PROTOCOL});

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(9999);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("Client connected");
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String response;
                if ((response = in.readLine()) != null) {
                    System.out.println("Received: " + response);
                    out.writeBytes("Successfully received message\n");
                } else {
                    out.writeBytes("Failed to receive message\n");
                }

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}