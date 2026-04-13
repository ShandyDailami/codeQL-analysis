import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_26708_SocketServer_A01 {
    public static void main(String[] args) {
        // Create the server socket
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started");

            while (true) {
                // Wait for a client to connect
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String message;
                    // Wait for a message from the client
                    while ((message = in.readLine()) != null) {
                        System.out.println("Received: " + message);
                        // Reply to the client
                        out.println("Hello, client, you sent: " + message);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}