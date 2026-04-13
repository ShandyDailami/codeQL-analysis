import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.Certificate;

public class java_28711_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 8080;
        try {
            ServerSocket serverSocket = new SSLServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                // Get the SSL certificates from the socket
                Certificate[] certs = sslSocket.getCertificateChain();
                for (Certificate cert : certs) {
                    System.out.println("Certificate: " + cert.toString());
                }

                // Get the input stream from the socket
                InputStream inputStream = sslSocket.getInputStream();

                // Get the output stream to the client
                OutputStream outputStream = sslSocket.getOutputStream();

                // Transfer data from the input stream to the output stream
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}