import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_11519_SocketServer_A07 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        final int port = 8080;
        boolean running = true;

        // Create server socket
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);

        while (running) {

            // Accept client connection
            Socket clientSocket = serverSocket.accept();

            // Create input and output stream
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Handle client connection
            handleClient(in, out, clientSocket);

            // Close resources
            out.close();
            in.close();
            clientSocket.close();
        }

        serverSocket.close();
    }

    private static void handleClient(BufferedReader in, PrintWriter out, Socket clientSocket) throws IOException, NoSuchAlgorithmException {
        String inputLine;

        // Get client's message
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            // Authenticate client by sending back an encrypted version of the client's message
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(inputLine.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            String encryptedMessage = sb.toString();
            out.println("Encrypted Message: " + encryptedMessage);
        }
    }
}