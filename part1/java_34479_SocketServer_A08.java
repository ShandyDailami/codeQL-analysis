import java.io.*;
import java.net.*;

public class java_34479_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

        Socket socket = server.accept();

        System.out.println("Connected to client on port " + socket.getPort());

        // Send a welcome message to the client
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello Client, You are connected to my Server!");

        // Create a new InputStreamReader and BufferedReader for handling input data
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        String inputLine;

        // Read client input and echo back
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.println("Server Echo: " + inputLine);
        }

        socket.close();
        server.close();
    }
}