import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_11420_SocketServer_A08 {

    public static void main(String[] args) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream keystoreStream = SocketServer.class.getResourceAsStream("/client.keystore")) {
            keyStore.load(keystoreStream, "password".toCharArray());
        }

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8443, keyStore, null, SSLServerSocket.SELECTOR);
        serverSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client connection...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        try (Socket clientSocket = socket;
             InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {

            System.out.println("Received request from client");

            // TODO: Handle client request
            // For now, just echo back the request
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            output.write(buffer, 0, bytesRead);

            System.out.println("Sent response back to client");
        }

        serverSocket.close();
    }
}