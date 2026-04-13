import java.io.*;
import java.net.*;
import java.util.*;

public class java_33724_SocketServer_A07 {
    private static final String AUTH_SERVER = "localhost";
    private static final int AUTH_SERVER_PORT = 9876;
    private static final int SERVER_PORT = 9877;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        System.out.println("Server is listening on port: " + SERVER_PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            // Initiate authentication
            Socket authSocket = new Socket(AUTH_SERVER, AUTH_SERVER_PORT);
            PrintWriter authOut = new PrintWriter(authSocket.getOutputStream(), true);
            authOut.println("A07_AuthFailure"); // Authentication failure

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client says: " + message);
                break; // For now, break after receiving the first message
            }

            clientSocket.close();
        }
    }
}