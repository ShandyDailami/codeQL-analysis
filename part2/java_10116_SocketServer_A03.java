import java.io.*;
import java.net.*;
import java.util.*;

public class java_10116_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234); // port 1234 for demonstration purposes
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket client = server.accept(); // waits for a client to connect
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String request = in.readLine(); // reads a line of text from the client
            System.out.println("Received request: " + request);

            // The following line is a simple example of an injection attack.
            // In a real-world scenario, it's important to ensure that the client never directly reads from the request,
            // as this can lead to a variety of attacks, including command injection.
            String response = "HTTP/1.1 200 OK\r\n\r\n" + request;
            out.write(response.getBytes());
            out.flush();

            client.close();
        }
    }
}