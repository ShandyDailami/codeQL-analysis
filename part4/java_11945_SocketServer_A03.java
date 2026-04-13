import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11945_SocketServer_A03 {
    public static void main(String[] args) throws IOException, SSLException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

            System.out.println("Server started");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                SSLSession sslSession = sslSocket.getSession();

                // Do something with sslSession...

                sslSocket.close();
           
            }
        } finally {
            serverSocket.close();
        }
    }
}