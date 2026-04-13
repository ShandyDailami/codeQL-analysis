import java.io.*;
import java.net.*;

public class java_09437_SocketServer_A03 {

    public static void main(String[] args) {

        // Initialize server socket
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                // Accept client socket
                Socket socket = serverSocket.accept();

                // Create input and output streams
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String inputLine;

                // Read incoming message
                while ((inputLine = in.readLine()) != null) {
                    // Do something with inputLine (e.g. decrypt it)
                    System.out.println("Received: " + inputLine);

                    // Send back an encrypted message
                    out.println("Echo: " + inputLine);
                }

                // Close the connection
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}