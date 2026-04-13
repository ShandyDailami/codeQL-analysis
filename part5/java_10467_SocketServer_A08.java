import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_10467_SocketServer_A08 {

    private static SSLServerSocket serverSocket = null;
    private static Socket socket = null;
    private static SSLSocket sslSocket = null;
    private static PrintWriter out = null;
    private static BufferedReader in = null;

    public static void main(String[] args) {

        try {

            // Set up SSL Server socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Accept client connection
            socket = serverSocket.accept();
            sslSocket = (SSLSocket) socket.getSocket();

            // Set up input and output streams
            out = new PrintWriter(sslSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            // Handshake
            SSLSession sslSession = sslSocket.getSession();
            sslSession.setEnabledProtocols(new String[] { SSLSession.TLSv1, SSLSession.TLSv1_1, SSLSession.TLSv1_2 });

            // Send response
            out.println("Hello, client!");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try { in.close(); } catch(Exception e){}
            }
            if (out != null) {
                try { out.close(); } catch(Exception e){}
            }
            if (sslSocket != null) {
                try { sslSocket.close(); } catch(Exception e){}
            }
            if (socket != null) {
                try { socket.close(); } catch(Exception e){}
            }
            if (serverSocket != null) {
                try { serverSocket.close(); } catch(Exception e){}
            }
        }
    }
}