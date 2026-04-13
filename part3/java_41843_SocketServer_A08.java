import java.io.*;
import java.net.*;
import java.util.*;

public class java_41843_SocketServer_A08 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                try (Socket client = server.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Received message from client: " + message);

                        // Checking for integrity failure
                        if (message.contains("bad_data")) {
                            System.out.println("Error: The received message contains integrity failure.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}