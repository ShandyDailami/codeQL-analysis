import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;

public class java_35154_SocketServer_A07 {
    private static final int PORT = 8080;
    private static KeyStore keyStore;

    static {
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("client.jks"), "password".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | KeyStoreException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected at: " + clientSocket.getInetAddress().getHostAddress());

            SSLServerSocket sslServerSocket = (SSLServerSocket) clientSocket;
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                // Perform authentication here using the keyStore and the clientMessage
                // For simplicity, let's just check if the message is "Hello, World!"
                if ("Hello, World!".equals(clientMessage)) {
                    out.println("Hello, World!");
                } else {
                    out.println("Authentication failed");
                }
            }

            sslSocket.close();
            clientSocket.close();
        }
    }
}