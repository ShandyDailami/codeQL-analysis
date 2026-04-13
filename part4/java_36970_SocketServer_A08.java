import java.io.*;
import java.net.*;
import java.util.*;

public class java_36970_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Step 1: create server socket and bind it to a port.
            server = new ServerSocket(8080);

            System.out.println("Server started on port 8080...");

            while (true) {
                // Step 2: wait for a client to connect
                socket = server.accept();

                System.out.println("Client connected...");

                // Step 3: send a message to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello Client, You are Connected to Server!");

                // Step 4: receive a message from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = in.readLine();
                System.out.println("Message from client: " + message);

                // Step 5: close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 6: close the server socket
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}