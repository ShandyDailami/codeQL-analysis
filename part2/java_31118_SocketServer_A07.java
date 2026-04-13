import java.io.*;
import java.net.*;

public class java_31118_SocketServer_A07 {
    private static int port = 12345;
    private static ServerSocket server;

    public static void main(String[] args) throws Exception {
        // Step 1: Create a server socket
        server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            // Step 2: Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            // Step 3: Handle the communication
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Step 4: Authenticate the client
            String authRequest = in.readLine();
            if (isValidAuthRequest(authRequest)) {
                out.println("Auth successful");
            } else {
                out.println("Auth failure");
                client.close();
                continue;
            }

            // Step 5: Send a response to the client
            out.println("Hello client, you are authenticated!");
            client.close();
        }
    }

    private static boolean isValidAuthRequest(String authRequest) {
        // Step 6: Implement authentication logic here
        // For the sake of simplicity, we'll just check if the request is null or empty
        return authRequest != null && !authRequest.isEmpty();
    }
}