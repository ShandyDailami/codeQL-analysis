import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_12136_SocketServer_A08 {

    public static void main(String[] args) {
        boolean useSSL = true;
        SSLServerSocketFactory sslServerSocketFactory = null;
        ServerSocket serverSocket = null;

        if (useSSL) {
            try {
                sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                e.printStackTrace();
                return;
            }
            try {
                serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
                serverSocket.setReuseAddress(true);
                System.out.println("Secure Socket Server started at " + serverSocket.getLocalSocketPort() + " port");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        } else {
            try {
                serverSocket = new ServerSocket(12345);
                serverSocket.setReuseAddress(true);
                System.out.println("Socket Server started at " + serverSocket.getLocalSocketPort() + " port");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");
                new EchoHandler(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}