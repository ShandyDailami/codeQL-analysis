import java.io.*;
import java.net.*;

public class java_15018_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8189);

        System.out.println("Server is listening on port 8189...");

        while (true) {

            // Wait for a client to connect
            Socket socket = serverSocket.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            // Get the client's input
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Perform security-sensitive operation related to Injection (e.g., SQL Injection)
                // In this example, we're just echoing back the input
                String newLine = "ECHO: " + inputLine;
                out.println(newLine);
            }

            // Close the connection
            socket.close();
        }
    }
}