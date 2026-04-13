import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class java_39217_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a new server socket at port 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected...");

            // Get the output stream from the client socket
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            // Create a reader for the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Read a message from the client
            String message = reader.readLine();
            System.out.println("Client message: " + message);

            // Send a response back to the client
            writer.println("Hello, client, your message was: " + message);

            // Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}