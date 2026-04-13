import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_34758_SocketServer_A01 {
    public static void main(String[] args) {
        // Create a new socket server
        try (Socket serverSocket = new Socket("localhost", 1234)) {
            // Create input and output streams
            try (BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true)) {
                String inputLine;
                // Read client input
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    // Perform some security-sensitive operation here
                    if (inputLine.equals("admin")) {
                        // Block access if input is 'admin'
                        out.println("Access Denied");
                    } else {
                        out.println("Hello, " + inputLine);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}