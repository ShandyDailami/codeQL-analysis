import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_03448_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        // Create a SSL Server socket.
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Listen for client connections.
        SSLSocket clientSocket = null;
        try {
            clientSocket = (SSLSocket) sslServerSocket.accept();
            clientSocket.startHandshake();
            SSLCertificate cert = clientSocket.getCertificate();
            System.out.println("Client certificate: " + cert.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Get the input and output streams.
        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();

        // Create a PrintWriter for the output stream.
        PrintWriter out = new PrintWriter(output, true);

        // Send a greeting message.
        out.println("Hello, client!");

        // Close the connection.
        clientSocket.close();
        sslServerSocket.close();
    }
}