import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_21540_SocketServer_A07 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket clientSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) throws IOException {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                clientSocket.setNeedClientAuth(true);

                inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

                SSLHandshake sh = clientSocket.startHandshake();
                if (!sh.isClientHelloSupported("SSLv3")) {
                    throw new IOException("Unsupported protocol");
                }

                // If the client did not authenticate, it sends an error message.
                if (!sh.getSession().isValidate()) {
                    outToClient.println("Error: Client not authenticated");
                    outToClient.flush();
                    continue;
                }

                String message;
                while ((message = inFromClient.readLine()) != null) {
                    System.out.println("Received: " + message);
                    outToClient.println("Message received: " + message);
                    outToClient.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}