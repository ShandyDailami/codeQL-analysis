import java.io.*;
import java.net.*;
import java.util.*;

public class java_13307_SocketServer_A07 {
    private static final String AUTH_FAILURE = "AUTH_FAILURE";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            try (InputStreamReader input = new InputStreamReader(socket.getInputStream());
                 BufferedReader reader = new BufferedReader(input)) {

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    if (AUTH_FAILURE.equals(message)) {
                        // Authentication failure.
                        // Send a response to the client.
                        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());
                        output.write("AUTH_FAILURE_RESPONSE\n");
                        output.flush();

                        System.out.println("Authentication failed. Sending response...");
                    } else {
                        // Authentication successful.
                        // Send a response to the client.
                        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());
                        output.write("AUTH_SUCCESS_RESPONSE\n");
                        output.flush();

                        System.out.println("Authentication successful. Sending response...");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}