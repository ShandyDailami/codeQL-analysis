import java.io.*;
import java.net.*;

public class java_15922_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Waiting for a client...");

            Socket socket = serverSocket.accept();
            System.out.println("A client has connected!");

            // Create a buffered reader and writer
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Receive a message from the client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            writer.println(response);

            // Close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}