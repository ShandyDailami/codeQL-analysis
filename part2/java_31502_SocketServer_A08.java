import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_31502_SocketServer_A08 {

    public static void main(String[] args) {
        new SocketServerExample().startServer();
    }

    private void startServer() {
        int port = 8080;
        try (Socket server = new Socket("localhost", port);
             BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
             PrintWriter out = new PrintWriter(server.getOutputStream(), true)) {

            String message = "Hello, World!";
            out.println(message);
            System.out.println("Client says: " + in.readLine());

            // Implementing security-sensitive operations related to A08_IntegrityFailure
            // For the sake of simplicity, we're just printing the received message to the console.
            // In a real-world application, you'd want to implement more robust security measures.
            System.out.println("Server received: " + in.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}