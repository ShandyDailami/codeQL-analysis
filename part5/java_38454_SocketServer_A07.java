import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_38454_SocketServer_A07 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket clientSocket;
    private static KeyPair keyPair;
    private static SSLServerSocketChannel sslServerSocketChannel;
    private static SSLSocketChannel sslSocketChannel;

    public static void main(String[] args) throws Exception {
        // Create a KeyPair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("SunRSASignature");
        keyPairGenerator.initialize(2048);
        keyPair = keyPairGenerator.generateKeyPair();

        // Create a SSLServerSocket
        serverSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null, SSLSocket.getDefaultSSLSocketFactory());
        serverSocket.setNeedClientAuth(true);

        // Accept a client connection
        clientSocket = (SSLSocket) serverSocket.accept();

        // Get SSLServerSocketChannel and SSLSocketChannel
        sslServerSocketChannel = (SSLServerSocketChannel) serverSocket.getChannel();
        sslSocketChannel = sslServerSocketChannel.acceptChannel();

        // Create a BufferedReader and InputStreamReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Receive request from the client
        String request = reader.readLine();
        System.out.println("Received request: " + request);

        // Send response to the client
        String response = "Server response: " + request;
        OutputStream out = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);
        writer.println(response);
    }
}