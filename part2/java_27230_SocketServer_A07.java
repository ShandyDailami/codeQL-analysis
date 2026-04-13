import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27230_SocketServer_A07 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9090;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started on port: " + SERVER_PORT);

            while (true) {
                try (Socket client = server.accept()) {
                    System.out.println("Accepted new connection from: " + client.getRemoteSocketAddress());

                    // Perform authentication
                    if (!authenticateClient(client)) {
                        System.out.println("Authentication failed. Closing connection.");
                        client.close();
                        continue;
                    }

                    // Handle client input
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    String input;
                    while ((input = in.readLine()) != null) {
                        System.out.println("Received: " + input);
                        out.println("Echo: " + input);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket client) throws IOException {
        // Implement your own authentication logic here. This is a placeholder.
        return true;
    }
}