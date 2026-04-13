import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36149_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // Create a new SSLServerSocket
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
        sslServerSocket. setNeedClientAuth(true);

        while (true) {
            // Wait for client connection
            socket = sslServerSocket.accept();

            // Create a new SSLSocket
            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(socket, true);

            // Perform handshake and get client cert
            SSLSession sslSession = sslSocket.getSession();
            Certificate cert = sslSession.getCertificate();
            System.out.println("Client Certificate: " + cert.toString());

            // Perform authentication
            sslSocket.startHandshake();

            // Process received data
            DataInputStream dis = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(sslSocket.getOutputStream());

            String request = dis.readUTF();
            dos.writeUTF("Hello, Client!");
            dos.flush();

            String response = dis.readUTF();
            System.out.println("Server response: " + response);

            // Close the connection
            sslSocket.close();
        }
    }
}