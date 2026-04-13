import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_21555_SocketServer_A03 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketServerFactory();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000, 10000, true);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello, client");

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
            }

            clientSocket.close();
        }
    }
}