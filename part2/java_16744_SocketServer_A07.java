import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_16744_SocketServer_A07 {

    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER"; // Replace with your client identifier
    private static final String CLIENT_PASSWORD = "CLIENT_PASSWORD"; // Replace with your client password

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Create Non-SSL Server Socket
            serverSocket = new ServerSocket(8080);

            // Accept connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                // Authentication
                sslSocket.setNeedClientAuth(true);
                SSLSession sslSession = sslSocket.getSession();

                if (sslSession.getProtocol() == SSLSession.VERSION_SSLv2) {
                    sslSocket = (SSLSocket) sslSocket.createWrappedSocket(clientSocket.getInputStream(), clientSocket.getOutputStream());
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

                // Get client certificate
                Certificate certificate = sslSocket.getRemoteCertificate();
                String clientCertificate = ((X509Certificate) certificate).getSubjectX500Principal();

                if (!clientCertificate.equals(CLIENT_IDENTIFIER) || !CLIENT_PASSWORD.equals(getClientPassword(clientCertificate))) {
                    out.write("FAIL\n".getBytes());
                    out.flush();
                    continue;
                }

                out.write("OK\n".getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close Socket
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }

    private static String getClientPassword(String clientCertificate) {
        // Implement your own client password retrieval logic here.
        // For the sake of this example, let's return the same password.
        return CLIENT_PASSWORD;
    }
}