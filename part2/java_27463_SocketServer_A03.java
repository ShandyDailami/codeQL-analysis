import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class java_27463_SocketServer_A03 {

    // Define the secret key
    private static final String KEY = "a secret kick ass";

    public static void main(String[] args) throws Exception {
        // Define server port
        int port = 1234;

        // Create a server socket
        ServerSocket serverSocket;
        if (args.length > 0) {
            serverSocket = new SSLServerSocket(port);
        } else {
            serverSocket = new ServerSocket(port);
        }

        System.out.println("Waiting for client on port " + port);

        // Accept client
        Socket socket = serverSocket.accept();
        System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

        // Create input and output streams
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Encrypt and decrypt data
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            String encryptedMessage = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes()));
            out.println(encryptedMessage);
        }

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}