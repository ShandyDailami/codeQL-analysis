import java.io.*;
import java.net.*;
import java.util.*;

public class java_13491_SocketServer_A03 {
    // Define port number
    private static final int PORT = 9876;
    
    public static void main(String[] args) throws Exception {
        // Create socket and set up server
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Accept client
            Socket client = server.accept();

            // Set up input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Receive data from client
            String data = in.readLine();
            System.out.println("Received: " + data);

            // Send response back to client
            String response = handleRequest(data);
            out.writeBytes(response + "\n");

            // Close the streams
            out.close();
            in.close();
            client.close();
        }
    }

    // Handle request (this is a placeholder, replace with real code)
    private static String handleRequest(String data) {
        // Simulate a security-sensitive operation
        // Inject malicious data into data
        String injectedData = "A03_Injection: " + data;
        System.out.println("Injected data: " + injectedData);
        return injectedData;
    }
}