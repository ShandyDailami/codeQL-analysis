import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_17586_SocketServer_A01 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { new X509TrustManager() }, null);
        serverSocket.setSSLContext(sslContext);

        System.out.println("Server is started");
        handleClients(serverSocket);
    }

    private static void handleClients(SSLServerSocket serverSocket) {
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SSLSocket sslSocket = (SSLSocket) clientSocket.getTransportSocket();
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

        try {
            // Send a message to the client
            out.writeUTF("Hello Client, you are now connected to the secure server!");
            String serverMessage = in.readLine();
            System.out.println("Server says: " + serverMessage);

            // Close the connection
            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}