import java.io.*;
import java.net.*;

public class java_13631_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read from the client
            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);

                // Perform security sensitive operation like SQL injection
                if (input.contains(";") || input.contains("--")) {
                    out.println("Invalid input. Please do not use injection attacks.");
                } else {
                    out.println("Thank you for connecting, " + input);
                }
            }

            // Close the connection
            socket.close();
        }
    }
}