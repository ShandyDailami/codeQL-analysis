import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.security.Principal;
import java.security.Key;
import java.security.cert.Certificate;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_29099_SocketServer_A08 {
    private static final int PORT = 6789;

    public static void main(String[] args) throws Exception {
        // Step 1: Create a ServerSocket
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Step 2: Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Step 3: Get the input and output streams
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Step 4: Create a BufferedReader to read data from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);

            // Step 5: Send a welcome message to the client
            writer.println("Welcome to the server!");

            // Step 6: Get user input and send it back to the client
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            writer.println("You said: " + userInput);

            // Step 7: Close the connection
            clientSocket.close();
        }
    }
}