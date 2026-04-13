import java.io.*;
import java.net.*;
import java.util.*;

public class java_24657_SocketServer_A03 {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on " + HOST + " port " + PORT);

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                    handleConnection(socket);
                }
            }
        } catch (IOException e) {
            System.err.println("IO Exception occurred: " + e.getMessage());
        }
    }

    private static void handleConnection(Socket socket) {
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {

            Scanner scanner = new Scanner(in);
            PrintWriter writer = new PrintWriter(out, true);

            String userInput;
            while ((userInput = scanner.nextLine()) != null) {
                if (isInjectionAttack(userInput)) {
                    writer.println("Attempted injection attack!");
                    break;
                }

                writer.println("Received: " + userInput);
            }
        } catch (IOException e) {
            System.err.println("IO Exception occurred: " + e.getMessage());
        }
    }

    private static boolean isInjectionAttack(String input) {
        // This is a simple check for a string containing a ';' or ' ' character.
        // In a real-world application, you'd want to use a more robust check.
        return input.contains(";") || input.contains(" ");
    }
}