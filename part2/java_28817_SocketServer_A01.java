import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_28817_SocketServer_A01 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {

        // create a server socket with SSL enabled
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
        } catch (SSLException e) {
            e.printStackTrace();
       
        }

        // accept connections
        Socket clientSocket = null;
        try {
            while ((clientSocket = serverSocket.accept()) != null) {
                System.out.println("New client connected");
                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());
                
                // Send a welcome message
                out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                out.flush();
                
                // Close the connection
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}