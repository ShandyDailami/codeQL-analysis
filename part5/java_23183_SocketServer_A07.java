import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_23183_SocketServer_A07 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444, null);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                SSLSocket sslSocket = (SSLSocket) clientSocket.createChannel(clientSocket.getSocket().getInetAddress(), clientSocket.getPort());
                sslSocket.setNeedClientAuth(true);
                sslSocket.setUseClientMode(true);

                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[] { new TrustManagerSocketCertificate() }, null);
                sslSocket.setSSLContext(sslContext);

                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                }

                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}