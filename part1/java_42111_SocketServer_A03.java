import java.io.*;
import java.net.*;

public class java_42111_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Create server socket on port 8080
        while (true) {
            Socket client = server.accept(); // Accept a client connection
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            
            String request = in.readLine(); // Read request from client
            out.writeBytes("Hello, client!\n"); // Send response
            out.flush();
            
            client.close();
        }
    }
}