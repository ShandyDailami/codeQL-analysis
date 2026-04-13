import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_26563_SocketServer_A08 {

    private static final String CLIENT_IDENTIFIER = "SSLClient";
    private static final int PORT = 4445;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Setup SSL Server
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());
            serverSocket.setSocketOption(SocketOption.SO_KEEPALIVE, true);

            // Setup SSL Client
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            clientSocket = (SSLSocket) sslSocketFactory.createSocket(serverSocket.getInetAddress(), PORT);
            clientSocket.setUseClientMode(true);
            clientSocket.setNeedClientAuth(true);

            // Establish SSL Connection
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(CLIENT_IDENTIFIER);

            // Wait for client authentication
            String response = in.readLine();
            if (!CLIENT_IDENTIFIER.equals(response)) {
                throw new IOException("Client Certificate authentication failed");
            }

            // Communicate with client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Message received");
            }

        } finally {
            clientSocket.close();
            serverSocket.close();
        }
    }
}