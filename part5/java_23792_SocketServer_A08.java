import java.io.*;
import java.net.*;

public class java_23792_SocketServer_A08 {

    private static int port = 8080;

    public static void main(String[] args) {

        // Step 1: Create a new server socket.
        try (ServerSocket server = new ServerSocket(port)) {

            System.out.println("Server started on port " + port);

            // Step 2: Accept incoming connections.
            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.println("Client connected");

                    // Step 3: Create new input and output streams.
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    // Step 4: Handle each request from the client.
                    String request;
                    while ((request = in.readLine()) != null) {
                        System.out.println("Received request: " + request);

                        // Step 5: Check for integrity failure.
                        if (request.equals("A08_IntegrityFailure")) {
                            out.println("Integrity failure detected");
                        } else {
                            out.println("No integrity failure detected");
                        }
                    }

                    // Step 6: Close the connection.
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}