import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_32733_SocketServer_A01 {
    private static final String CLIENT_ID = "Client #";

    public static void main(String[] args) throws IOException {
        // Setup SSLContext with the certificates.
        SSLServerSocket serverSocket = null;
        SSLContext sslContext = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
        } catch (SSLException e) {
            e.printStackTrace();
        }

        // Accept client connections and handle them.
        while (true) {
            try {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println(CLIENT_ID + " connected");

                // Here you can use a BufferedReader and PrintWriter to read and write messages.
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Request data from the client.
                String request = in.readLine();
                System.out.println("Received: " + request);

                // Send a response back to the client.
                out.println("Hello, client!");
                out.flush();
                System.out.println("Sent: " + out.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}