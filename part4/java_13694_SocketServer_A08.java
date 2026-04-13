import java.io.*;
import java.net.*;

public class java_13694_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Creating a socket server on port 8888
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("Waiting for client on port " + 8888);

        // Accepting a client connection
        Socket socket = serverSocket.accept();

        // Wrap the socket in a BufferedReader for easy reading of the request
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Sending a welcome message to the client
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Welcome to the Socket Server!");

        String request;
        while ((request = in.readLine()) != null) {
            if (request.equals("exit")) {
                out.println("Bye!");
                break;
            }

            // Encrypt the request
            String encryptedRequest = encrypt(request);

            // Sending the encrypted request to the client
            out.println(encryptedRequest);

            // Sending a response back to the client
            out.println("Server: I received your message: " + encryptedRequest);
        }

        // Close the connections
        socket.close();
        serverSocket.close();
    }

    // Simple encryption function
    public static String encrypt(String message) {
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            encryptedMessage += (char)(message.charAt(i) + 1);
        }
        return encryptedMessage;
    }
}