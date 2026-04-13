import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_42039_SocketServer_A03 {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // port number
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = serverSocket.accept(); // blocks until a client connects
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                // process the received message
                String response = processMessage(message);

                // send the response back to the client
                out.println(response);
            }

            socket.close();
        }
    }

    private static String processMessage(String message) throws NoSuchAlgorithmException {
        // Simulate injection by hashing the input message
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(message.getBytes());

        // Remove all non-alphanumeric characters and convert to lowercase
        String safeMessage = new String(hash, "UTF-8").substring(0, 10).toLowerCase();

        // TODO: Add additional security-sensitive operations here (e.g., encryption, authentication)

        return safeMessage;
    }
}