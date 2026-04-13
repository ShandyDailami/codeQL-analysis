import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_39992_SocketServer_A03 {
    private static final String[] ALLOWED_HOSTS = {"127.0.0.1", "localhost"};

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            System.err.println("Could not listen on port 12345.");
            System.exit(-1);
        }

        System.out.println("Waiting for client connection...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
        sslSocket.setNeedClientAuth(true);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String userHostAddress = clientSocket.getInetAddress().getHostAddress();
        for (String host : ALLOWED_HOSTS) {
            if (host.equals(userHostAddress)) {
                out.println("Hello, client!");
                out.flush();
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                }
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}