import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_19212_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(12345, 100, InetAddress.getByName("localhost"));
        socket.setReuseAddress(true);

        SSLServerSocket serverSocket = (SSLServerSocket) socket;
        serverSocket.setNeedClientAuthentication(true);

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] {new TrustAllCertificatesTrustManager()}, new java.security.SecureRandom());

        Socket acceptedSocket;

        while ((acceptedSocket = serverSocket.accept()) != null) {
            SSLSocket sslSocket = (SSLSocket) acceptedSocket;
            sslSocket.setSSLSocket(sslSocket);
            sslSocket.setSSLContext(sslContext);

            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("Received: " + inputLine);
            }

            sslSocket.close();
        }
    }
}