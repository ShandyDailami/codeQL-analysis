import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21438_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setNeedClientAuthentication(true); // Enable client authentication

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");

            // Send certificate to client
            try (InputStream input = clientSocket.getInputStream();
                 OutputStream output = clientSocket.getOutputStream()) {
                byte[] bytes = new byte[1024];
                input.read(bytes);

                output.write("Hello, client".getBytes());
                output.flush();
            }

            clientSocket.close();
        }
    }
}