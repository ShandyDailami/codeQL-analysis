import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_20897_SocketServer_A03 {

    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketServerFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);
            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("Client connected");

            SSLInputStream inputStream = (SSLLInputStream) clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Received request: " + request);
                writer.println("Hello, " + request + "!");
            }

            clientSocket.close();
        } catch (SSLException e) {
            System.out.println("SSL Exception: " + e.getMessage());
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}