import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20805_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        // Step 1: Create a ServerSocket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port: 8080");

        while (true) {
            // Step 2: Accept a connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Step 3: Create a BufferedReader to read data from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Step 4: Read a message from the client
            String message = reader.readLine();
            System.out.println("Received message: " + message);

            // Step 5: Create a PrintWriter to send data back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Step 6: Send a response to the client
            writer.println("Message received, thank you!");

            // Step 7: Close the connection
            socket.close();
        }
    }
}