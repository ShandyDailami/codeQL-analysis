import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19944_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        while (true) {
            try {
                serverSocket = new ServerSocket(PORT);
                Socket clientSocket = serverSocket.accept();

                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Here we use the Secure Socket Extension (SSSE)
                // to encrypt the data sent from the client to the server.
                // This is a simplified example and does not provide a secure server.
                // In a real world scenario, you would use SSL/TLS for security.
                clientSocket.setSoTimeout(60000);

                // Here we read the encrypted data from the client
                // and echo it back to the client using SSLSocket
                SSLSocket sslSocket = (SSLSocket) clientSocket.getDefaultSSLSocket();
                sslSocket.setEnabledCipherSuites(sslSocket.getSupportedCipherSuites());

                // Write to the client
                String echoMessage = "Echo: " + new String(clientSocket.getInputStream().readNBytes(clientSocket.getInputStream().available()));
                sslSocket.getOutputStream().write(echoMessage.getBytes());
                sslSocket.getOutputStream().flush();

                // Close the connection
                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                serverSocket.close();
            }
        }
    }
}