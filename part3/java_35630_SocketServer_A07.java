import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_35630_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            // Create a server socket at port 8080
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            // Wait for client to connect
            Socket client = server.accept();
            System.out.println("Client connected");

            // Read from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Simple echo
                out.println("Echo: " + message);
            }

            // Close the connection
            client.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}