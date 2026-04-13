import java.io.*;
import java.net.*;

public class java_21119_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started at port 6000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            // Create output stream
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);
                // Modify input here for security sensitive operation
                // For example:
                if (input.equals("break_the_chain")) {
                    out.println("Access Denied");
                    break;
                } else {
                    out.println("Hello, Client!");
                }
            }

            // Close the connection
            socket.close();
        }
    }
}