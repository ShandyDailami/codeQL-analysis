import javax.net.ssl.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29913_SocketServer_A07 {
    private SSLServerSocket serverSocket;

    public java_29913_SocketServer_A07(int port) {
        SSLServerSocket socket;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            socket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            socket.setNeedClientAuth(true);

            // Setup SSL Context
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAllCerts()}, null);
            socket.setSSLContext(sslContext);

            this.serverSocket = socket;
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    public void startServer() {
        new Thread(() -> {
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    InputStream inputStream = clientSocket.getInputStream();
                    OutputStream outputStream = clientSocket.getOutputStream();

                    // Send a response
                    outputStream.write("Hello, client!".getBytes());
                    outputStream.flush();

                    clientSocket.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new SecureServer(8080).startServer();
    }
}

class TrustAllCerts implements X509TrustManager {
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public void checkClientTrusted(X509Certificate[] certs, String authType) {}

    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
}