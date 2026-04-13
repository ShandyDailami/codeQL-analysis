import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_09527_SocketServer_A08 {

    public static void main(String[] args) {

        boolean ssl = true;

        // Create a server socket
        if (ssl) {
            try {
                SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8443, InetAddress.getByName("localhost"));
                System.out.println("Server is running on port 8443...");
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted...");

                // Get the SSL socket
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.setNeedClientAuthentication(true);
                sslSocket.startHandshake();

                // Check if handshake was successful
                if (sslSocket.isClientHelloSupported(true)) {
                    System.out.println("Handshake was successful...");
                }

                // Continue with the rest of the program
                // ...

                // Close the server socket
                serverSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                System.out.println("Server is running on port 8080...");
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted...");

                // Continue with the rest of the program
                // ...

                // Close the server socket
                serverSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}