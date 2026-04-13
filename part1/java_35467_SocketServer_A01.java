import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_35467_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 1234
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(1234);

            while (true) {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept();

                // Get the input and output streams from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read from the client
                String message = in.readLine();
                System.out.println("Client says: " + message);

                // Send back a response to the client
                out.println("Server says: Hello, client!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}