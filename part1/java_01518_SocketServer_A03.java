import java.net.*;
import java.io.*;

public class java_01518_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345); // opens port 12345
        System.out.println("Waiting for client...");

        Socket client = server.accept(); // waits for client to connect
        System.out.println("Client connected");

        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        // Receive message from client
        String message = in.readLine();
        System.out.println("Received: " + message);

        // Send back message to client
        String response = "Hello, Client!";
        out.writeUTF(response);
        out.close();

        // Closing connection
        client.close();
        server.close();
    }
}