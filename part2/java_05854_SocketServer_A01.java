import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_05854_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        int port = 6000;
        Socket socket = new Socket("localhost", port);

        // Create input and output streams
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        // Send authentication request
        writer.println("AUTHENTICATE");

        // Read the response
        String response = reader.readLine();

        // Authenticate the client
        if (response.equals("AUTHENTICATED")) {
            System.out.println("Client authenticated successfully");

            // Now the server can start sending and receiving data
            while (true) {
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // Send a response back to the client
                writer.println("Message received");
            }
        } else {
            System.out.println("Client authentication failed");
        }

        socket.close();
    }
}