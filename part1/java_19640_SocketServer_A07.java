import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class java_19640_SocketServer_A07 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "_OFB";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444, 1000, InetAddress.getByName("localhost"));
        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;

        KeyPair keyPair = generateKeyPair();
        Key secretKey = new SecretKeySpec(keyPair.getPrivate().getEncoded(), ALGORITHM);

        SSLServerSocket secureSocket = (SSLServerSocket) sslServerSocket.accept();
        SSLSocket socket = (SSLSocket) secureSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message, response;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            response = "Hello, " + message;
            out.println(response);
        }
        out.close();
        in.close();
        socket.close();
        secureSocket.close();
        serverSocket.close();
    }

    private static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("AES");
        keyPairGenerator.initialize(128);
        return keyPairGenerator.generateKeyPair();
    }
}