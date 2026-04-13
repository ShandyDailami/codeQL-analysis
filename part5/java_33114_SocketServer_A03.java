import java.io.*;
import java.net.*;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class java_33114_SocketServer_A03 {
    private static final String SERVER_SOFTWARE = "SecureSocketServer";
    private static final String SERVER_INFO = "Server software: " + SERVER_SOFTWARE;
    private static final String VERSION = "Version: 1.0";
    private static final String SOCKET_SERVER_INFO = SERVER_INFO + "\n" + VERSION;

    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;
    private final KeyPair keyPair;
    private final Signature signature;

    public java_33114_SocketServer_A03(Socket socket, KeyPair keyPair) throws NoSuchAlgorithmException, InvalidKeyException {
        this.socket = socket;
        this.keyPair = keyPair;
        this.writer = new PrintWriter(socket.getOutputStream(), true);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.signature = Signature.getInstance("SHA1WithRSA");
    }

    public void start() throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        writer.println(SOCKET_SERVER_INFO);

        String message;
        while ((message = reader.readLine()) != null) {
            byte[] data = message.getBytes();

            // Encrypt data using RSA
            byte[] encryptedData = signature.sign(data, keyPair.getPrivate());

            // Sign the encrypted data
            byte[] signatureData = signature.sign(encryptedData);

            // Send the encrypted data and the signature
            writer.println(Arrays.toString(encryptedData) + " " + Arrays.toString(signatureData));
       
            writer.flush();
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();

        ServerSocket serverSocket = new ServerSocket(4444);
        while (true) {
            Socket socket = serverSocket.accept();
            new SecureSocketServer(socket, keyPair).start();
        }
    }
}