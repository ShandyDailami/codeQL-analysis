import java.io.*;
import java.net.*;

public class java_21042_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // listening on port 1234
            System.out.println("Waiting for client...");
            
            Socket client = server.accept(); // accept client
            System.out.println("Client connected");
            
            // create streams for communication
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            String message;
            
            // read and respond to client
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Hello, Client!");
            }
            
            // close streams
            out.close();
            in.close();
            client.close();
            server.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}