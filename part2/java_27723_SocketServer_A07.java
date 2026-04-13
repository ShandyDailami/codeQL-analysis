import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_27723_SocketServer_A07 {
    private static final String CLIENT_IDENTIFIER = "Client";
    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            // Create SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuthentication(true);

            // Accept Client Connection
            socket = sslServerSocket.accept();
            socket.setSoTimeout(10000);

            System.out.println("Client Connected");

            // Send Client Identifier
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(CLIENT_IDENTIFIER);

            // Receive Server Identifier
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverIdentifier = in.readLine();

            // Compare Server and Client Identifier
            if (serverIdentifier.equals(CLIENT_IDENTIFIER)) {
                System.out.println("Server Identifier Matched");
            } else {
                throw new IOException("Identifiers do not match");
            }
        } catch (SSLException e) {
            System.out.println("SSLException: " + e.getMessage());
        } finally {
            // Close Socket and Server Socket
            socket.close();
            sslServerSocket.close();
        }
    }
}