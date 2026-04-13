import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_07214_SocketServer_A08 {
    private static SSLServerSocket serverSocket;
    private static DataInputStream inFromClient;
    private static DataOutputStream outToClient;
    private static SSLContext sslContext;

    private static SSLServerSocket getServerSocket(int port) throws IOException {
        sslContext = SSLContext.getInstance("TLS");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        KeyStore coserialKeyStore = KeyStore.getInstance("JKS");

        try (InputStream resourceAsStream = new FileInputStream("server.jks")) {
            keyStore.load(resourceAsStream, "password".toCharArray());
            coserialKeyStore.load(resourceAsStream, "password".toCharArray());
        }

        sslContext.init(keyStore, coserialKeyStore, null);

        serverSocket = (SSLServerSocket) sslContext.getServerSocket(port);
        serverSocket.setNeedClientAuth(true);

        return serverSocket;
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
        sslSocket.setNeedClientAuth(true);

        inFromClient = new DataInputStream(sslSocket.getInputStream());
        outToClient = new DataOutputStream(sslSocket.getOutputStream());

        // Send response to client
        outToClient.writeUTF("Hello Client, you are authenticated!");
        outToClient.flush();

        // Read request from client
        String messageFromClient = inFromClient.readUTF();
        System.out.println("Message from client: " + messageFromClient);

        sslSocket.close();
    }

    public static void main(String[] args) throws IOException {
        int port = 1234;

        try {
            getServerSocket(port);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Server started");

        while (true) {
            try {
                handleClient(serverSocket.accept());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}