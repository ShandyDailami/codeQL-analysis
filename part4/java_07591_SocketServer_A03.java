import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_07591_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket sock = new ServerSocket(8080);
        SSLServerSocket serverSocket = (SSLServerSocket) sock;
        serverSocket.setEnabledCipherSuites(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});
        serverSocket.setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
        SSLServerSocket socketSecured = (SSLServerSocket) sslContext.getServerSocket(serverSocket);

        System.out.println("Waiting for client connection...");

        Socket clientSocket = socketSecured.accept();
        System.out.println("Client connected!");

        SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();

        // Read data from the client
        InputStream input = sslSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Received: " + line);
        }

        sslSocket.close();
        serverSocket.close();
    }
}