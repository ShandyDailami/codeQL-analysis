import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_15125_SocketServer_A07 {
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER"; // Change this to your client identifier

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);

            // Create SSLContext using TLS
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustManagerSSL() }, null);
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setSSLContext(sslContext);

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                SSLSocket sslSocket = (SSLSocket) socket.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

                String clientInfo = in.readLine();
                if (!clientInfo.equals(CLIENT_IDENTIFIER)) {
                    System.out.println("Client authentication failed");
                    sslSocket.close();
                    continue;
                }

                // If authentication passed, continue with the communication
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
                out.println("Connection successful");
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sslServerSocket.close();
        }
    }
}