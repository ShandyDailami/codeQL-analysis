import java.io.*;
import java.net.*;
import java.util.*;

public class java_20668_SocketServer_A08 {
    private static boolean stop = false;
    private static int port = 5000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a ServerSocket that listens on the port we specified.
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (!stop) {
                // Step 2: Wait for a client to connect to this server.
                socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Step 3: Send the server a welcome message to the client.
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Welcome to the server! You are connected to port " + socket.getPort());

                // Step 4: Process the client's input and send a response.
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String input;

                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    out.println("You sent: " + input);

                    // For A08_IntegrityFailure:
                    // Step 4a: For the sake of the example, we'll just check for an "exit" command.
                    if (input.equalsIgnoreCase("exit")) {
                        stop = true;
                    }

                    // Step 4b: To illustrate a lack of security in our program.
                    // The following line could be a real-world application for example.
                    // out.println("Acknowledged!");
                }

                socket.close();
            }
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}