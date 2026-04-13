import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_05445_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // Create a server socket
        int port = 8080;
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Handle the client connection
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            // Get the input and output streams
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Read a line from the client
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Check for injection
                if (checkInjection(inputLine)) {
                    System.out.println("Input contains injection attempt, closing connection");
                    clientSocket.close();
                    return;
                }

                // Send a response back to the client
                out.println("Hello, you sent: " + inputLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkInjection(String input) {
        // Simple check for SQL injection
        if (input.contains(";") || input.contains("--") || input.contains("'")) {
            return true;
        }
        return false;
    }
}