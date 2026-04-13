import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_31833_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            // Create SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            serverSocket.setNeedClientAuthentication(true);

            // Accept incoming connection
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            // Create InputStream and OutputStream
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                out.println("SERVER: " + inputLine);
            }

            clientSocket.close();
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}