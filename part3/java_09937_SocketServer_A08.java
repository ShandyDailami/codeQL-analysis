import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_09937_SocketServer_A08 {
    private final int port;

    public java_09937_SocketServer_A08(int port) {
        this.port = port;
    }

    public void startServer() {
        Runnable clientHandler = () -> {
            try {
                SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(port);
                while (true) {
                    SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                    System.out.println("Client connected");

                    // Verify if client is authenticated
                    try (InputStream in = clientSocket.getInputStream();
                         OutputStream out = clientSocket.getOutputStream()) {

                        // Read the client's certificate to verify its authenticity
                        KeyStore clientCertificate = KeyStore.getInstance("X509");
                        try (InputStream certInputStream = in) {
                            clientCertificate.load(certInputStream, "password".toCharArray());
                        }

                        // Continue if the client is authenticated
                        if (clientCertificate.isKeyEntryValid("password".toCharArray())) {
                            System.out.println("Client authenticated");

                            // Handle client communication
                            handleClient(clientSocket, in, out);
                        } else {
                            System.out.println("Client not authenticated");
                       
                            clientSocket.close();
                        }
                    } catch (CertificateException | IOException e) {
                        e.printStackTrace();
                        clientSocket.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(clientHandler).start();
    }

    private void handleClient(SSLSocket clientSocket, InputStream in, OutputStream out) throws IOException {
        // Read and send a message to the client
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        out.write(("Hello, Client!").getBytes());
    }

    public static void main(String[] args) {
        new SecureServer(8080).startServer();
    }
}