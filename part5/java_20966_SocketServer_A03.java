import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_20966_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        while (true) {
            try {
                Socket socket = new Socket("localhost", PORT);
                System.out.println("Client connected");

                // Read the client request
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Send a response
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Hello, client!");

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}