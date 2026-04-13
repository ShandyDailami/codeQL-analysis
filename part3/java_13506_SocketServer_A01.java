import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_13506_SocketServer_A01 {

    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            System.out.println("Waiting for client connection...");

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                SSLSocket sslClientSocket = (SSLSocket) clientSocket.createChannel(clientSocket.getInetAddress());
                sslClientSocket.setNeedClientAuth(true);

                SSLCertificateRequest certificateRequest = (SSLCertificateRequest) sslClientSocket.getProtocolRequests();
                certificateRequest.setRequestedCertificates(new X509Certificate[]{});

                SSLSession sslSession = sslClientSocket.getSession();
                sslSession.setCipherSuites(new String[]{"SSL_RSA_WITH_RC4_128", "SSL_RSA_WITH_RC4_8", "SSL_RSA_EXPORT_WITH_RC4_8"});

                BufferedReader reader = new BufferedReader(new InputStreamReader(sslClientSocket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(sslClientSocket.getOutputStream());

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    writer.write(("Message: " + line).getBytes());
                    writer.newLine();
                    writer.flush();
                }

                sslClientSocket.close();
                System.out.println("Client disconnected!");
            }
        } finally {
            serverSocket.close();
        }
    }
}