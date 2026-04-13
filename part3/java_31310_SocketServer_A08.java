import java.io.*;
import java.net.*;

public class java_31310_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for client on port: " + server.getLocalPort());

        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted connection from: " + client.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String message, response;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                response = processRequest(message);
                out.writeBytes(response + "\n");
            }

            client.close();
        }
    }

    private static String processRequest(String request) {
        // This is where you would process the request, which could involve
        // checking the request for integrity, validating it, and then responding accordingly.
        // For this example, we will just return a simple response.
        return "Server received your message: " + request;
    }
}