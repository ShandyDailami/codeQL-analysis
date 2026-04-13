import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_03360_SocketServer_A03 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;

        try {
            // Create a server socket
            socket = new ServerSocket(PORT);

            // Generate a self-signed SSL certificate
            SSLServerSocket sslServerSocket = (SSLServerSocket) socket;
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAllCertificates() }, null);
            sslServerSocket.accept();
            sslSocket = (SSLServerSocket) sslContext.getServerSocketSocket();

            // Handle connections
            while (true) {
                Socket connectionSocket = sslSocket.accept();
                System.out.println("Accepted new connection from " + connectionSocket.getRemoteSocketAddress());

                // Create I/O streams
                InputStream input = connectionSocket.getInputStream();
                OutputStream output = connectionSocket.getOutputStream();

                // Create a new thread for each connection
                Thread thread = new Thread(new SocketHandler(input, output));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sslSocket != null) {
                sslSocket.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}

class SocketHandler implements Runnable {
    private InputStream input;
    private OutputStream output;

    public java_03360_SocketServer_A03(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int length;

            // Read data from the input stream
            while ((length = input.read(buffer)) != -1) {
                output.write(buffer, 0, length);
                output.flush();
            }

            // Close the connection
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// TrustAllCertificates class is a trust manager that allows all SSL certificates
class TrustAllCertificates implements X509TrustManager {
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public boolean isClientTrusted(X509Certificate[] certs) {
        return true;
    }

    public boolean isServerTrusted(X509Certificate[] certs) {
        return true;
    }
}