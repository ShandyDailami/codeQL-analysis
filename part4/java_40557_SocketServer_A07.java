import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_40557_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        int port = 8080;

        // Create a new server socket at port 8080.
        Socket serverSocket = new Socket("localhost", port);

        // Get the input stream from the server socket.
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

        // Get the output stream to the client.
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

        // Send the client a welcome message.
        out.println("Welcome to the secure server!");

        // Create a message digest instance for hashing the user's password.
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Read the user's password from the client.
        String input = in.readLine();
        byte[] hash = md.digest(input.getBytes());

        // Convert the hash to a base64 string.
        String encodedHash = Base64.getEncoder().encodeToString(hash);

        // Send the hashed password to the client.
        out.println(encodedHash);

        // Close the server socket and input stream.
        serverSocket.close();
        in.close();
    }
}