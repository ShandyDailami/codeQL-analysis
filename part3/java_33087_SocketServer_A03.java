import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_33087_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuthentication(true);

            while (true) {
                socket = (SSLSocket) serverSocket.accept();
                socket.startHandshake();

                SSLSession socketSession = socket.getSession();

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello Client, you connected to the secure server!");
            }
        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}