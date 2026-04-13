import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_02037_SocketServer_A03 {
    private static final String CLIENT_IDENTIFIER = "TLSv1.2";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

            while (true) {
                clientSocket = (SSLSocket) serverSocket.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                System.out.println("Accepted a connection from " + clientSocket.getRemoteSocketAddress());

                String message = in.readLine();
                System.out.println("Received: " + message);

                // Encryption
                String encryptedMessage = encrypt(message);
                out.writeBytes(encryptedMessage + "\n");

                clientSocket.close();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static String encrypt(String message) {
        // Implement your own encryption algorithm here. For the sake of simplicity, let's encrypt the message by adding 1
        return Integer.toString(message.length() + 1);
    }
}