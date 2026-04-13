import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_11250_SocketServer_A08 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setEnabled(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");

            // Handshake
            SSLCertificate cert = clientSocket.getCertificate();
            System.out.println("Client's certificate: " + cert.toString());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
                out.println("Server's response");
            }
       
            clientSocket.close();
        }
    }
}