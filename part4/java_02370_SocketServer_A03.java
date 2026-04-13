import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_02370_SocketServer_A03 {
    private static final int PORT = 443;
    private static final String ALTERNATE_HOSTNAME = "localhost";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setHostname(ALTERNATE_HOSTNAME);

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Server says: " + message);
            }
        } finally {
            serverSocket.close();
        }
    }
}