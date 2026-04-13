import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_40088_SocketServer_A08 {

    private static final String CLIENT_HANDSHAKE_FAILURE = "Client Handshake failure";

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                SSLSession sslSession = clientSocket.getSession();

                if (sslSession == null) {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println(CLIENT_HANDSHAKE_FAILURE);
                    continue;
                }

                // Start reading from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                }
            }
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}