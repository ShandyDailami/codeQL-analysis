import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_19475_SocketServer_A01 {
    private static SSLServerSocket serverSocket;
    private static BufferedReader inFromClient;
    private static DataOutputStream outToClient;
    private static SSLSocket clientSocket;
    private static String clientIP;

    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            KeyStore passwordStore = KeyStore.getInstance("JKS");
            SSLServerSocket socket = null;
            socket = (SSLServerSocket) socket.createServerSocket(10000, 1000, null, passwordStore, keyStore);
            socket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, passwordStore, null);

            while (true) {
                clientSocket = (SSLSocket) sslContext.getSocketFactory().createSocket(socket.accept());
                clientSocket.startHandshake();
                clientIP = clientSocket.getRemoteSocketAddress().toString();
                inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToClient = new DataOutputStream(clientSocket.getOutputStream());

                // Sending response to client
                outToClient.writeUTF("Hello, client, you are connected to: " + clientIP);
                outToClient.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}