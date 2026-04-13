import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class java_01400_SocketServer_A07 {
    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

                // Start the handshake process
                SSLHandshake sh = new SSLHandshake(clientSocket.getInputStream(), outToClient);
                SSLContext context = SSLContext.getInstance("SSL");
                context.init(null, new X509Certificate[]{sh.getClientCertificate()}, null);

                // Authenticate the client
                if (sh.performHandshake() != SSLHandshake.SUCCESS) {
                    closeConnection();
                    continue;
                }

                // Process the request from the client
                String request = inFromClient.readLine();
                outToClient.println("Hello, " + request);

                closeConnection();
            }
        } catch (SSLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            inFromClient.close();
            outToClient.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}