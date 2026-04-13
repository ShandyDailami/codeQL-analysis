import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_32625_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        System.out.println("Starting server on port " + port);

        while (true) {
            Socket socket = new Socket("localhost", port);

            System.out.println("Connected to client");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Simulate integrity failure by responding with an empty response
                out.println(message.equals("IntegrityFailure") ? "" : message);
            }

            socket.close();
        }
    }
}