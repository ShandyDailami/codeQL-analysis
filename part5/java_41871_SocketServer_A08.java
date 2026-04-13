import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_41871_SocketServer_A08 {

    public static void main(String[] args) throws IOException {

        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;
        PrintWriter out = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                socket = (SSLSocket) serverSocket.accept();
                socket.setNeedClientAuthentication(true);

                // Establish a new writer thread for the client
                out = new PrintWriter(socket.getOutputStream(), true);

                // Send a greeting message
                out.println("Hello client, you connected to the server!");
            }
        } finally {
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                socket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}