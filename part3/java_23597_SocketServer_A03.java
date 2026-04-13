import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_23597_SocketServer_A03 {
    private static final String PASSWORD = "secure";
    private static SSLServerSocket serverSocket = null;
    private static SSLSocket clientSocket = null;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setPassword(PASSWORD.getBytes());

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);
                clientSocket.setSSLContext(sslContext);

                OutputStream out = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello Client, you are connected to the server");

                clientSocket.close();
            }
        } catch (IOException | SSLException e) {
            e.printStackTrace();
        }
    }
}

class TrustAnyTrustManager implements X509TrustManager {
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public boolean isTrusted(X509Certificate[] certs) {
        return true;
    }

    public boolean checkClientTrusted(X509Certificate[] certs, String authType) {
        return true;
    }

    public boolean checkServerTrusted(X509Certificate[] certs, String authType) {
        return true;
    }
}