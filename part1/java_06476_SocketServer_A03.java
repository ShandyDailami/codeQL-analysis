import java.net.*;
import java.io.*;

public class java_06476_SocketServer_A03 {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create input and output stream
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client says: " + inputLine);

                // Simulate a security-sensitive operation
                String response = processInput(inputLine);

                out.println("Server says: " + response);
              }

            socket.close();
        }
    }

    private static String processInput(String input) {
        // This is a placeholder for security-sensitive operation
        // You may use any other method here to handle the input
        // This is just a simple example
        return "Hello " + input;
    }
}