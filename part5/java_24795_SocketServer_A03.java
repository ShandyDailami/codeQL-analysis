import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_24795_SocketServer_A03 {
    private static final String CLIENT_IDENTIFIER = "ChatServer";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new String[] {CLIENT_IDENTIFIER}, null);
            serverSocket.setSSLContext(sslContext);
            System.out.println("Waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.writeBytes(message + "\n");
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}