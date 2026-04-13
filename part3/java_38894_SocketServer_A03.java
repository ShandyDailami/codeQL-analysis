import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_38894_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;

        // Server socket
        try (Socket serverSocket = new Socket("localhost", port)) {
            System.out.println("Connected to port " + port);

            // BufferedReader and PrintWriter for reading and writing
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

            String inputLine;

            // Listen for client input and send back an answer
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Hello, client, your message was received.");
            }

            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}