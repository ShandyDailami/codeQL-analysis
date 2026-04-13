import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_29711_SocketServer_A07 {

    private static final String SSL_PORT = "12345";
    private static SSLServerSocket sslServerSocket = null;
    private static Socket sock = null;
    private static BufferedReader in = null;
    private static PrintWriter out = null;
    private static SSLServerSocketFactory sslServerSocketFactory;

    public static void main(String[] args) throws Exception {

        System.out.println("Starting server at port " + SSL_PORT);
        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
        sslServerSocket.setNeedClientAuth(true);

        while (true) {

            sock = sslServerSocket.accept();
            sslServerSocket.setNeedClientAuth(true);
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            out = new PrintWriter(sock.getOutputStream(), true);

            System.out.println("Client accepted");

            // Perform authentication
            if (authenticate(sock)) {
                // Connection is authenticated, handle requests
                handleRequests();
            } else {
                System.out.println("Authentication failed, closing connection");
                out.println("Server Error: Authentication Failed");
                out.flush();
                sock.close();
            }
        }
    }

    private static boolean authenticate(Socket sock) throws IOException {
        SSLSocket sslSock = (SSLSocket) sock.getSocket();
        sslSock.startHandshake();
        // You can add more security measures here. For example, you can add a password
        // and the client sends it in the first handshake.
        return sslSock.getSession().isValidate();
    }

    private static void handleRequests() throws IOException {
        String request;
        while ((request = in.readLine()) != null) {
            System.out.println("Received: " + request);
            out.println("Server received: " + request);
            out.flush();
        }
    }
}