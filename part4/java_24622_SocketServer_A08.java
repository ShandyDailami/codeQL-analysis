import java.io.*;
import java.net.*;

public class java_24622_SocketServer_A08 {

    private static int port = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException ex) {
            System.out.println("Error setting up the server: " + ex);
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    System.out.println("Error closing the server: " + ex);
                }
            }
        }
    }

    public static void handleClient(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                // For security-sensitive operations related to A08_IntegrityFailure
                // Verify the integrity of the received data.
                // If the received data is not valid, return an error message.
                if (!isValidData(inputLine)) {
                    out.println("Error: Invalid data received!");
                    continue;
                }

                // If the received data is valid, continue the communication.
                out.println("Data accepted: " + inputLine);
            }
        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex);
        }
    }

    public static boolean isValidData(String data) {
        // Add your security-sensitive operations related to A08_IntegrityFailure here.
        // Return true if the data is valid, false otherwise.
        // For instance, you can check if the data is not null or empty.
        return !(data == null || data.trim().isEmpty());
    }
}