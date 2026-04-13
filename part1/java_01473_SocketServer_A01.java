import java.io.*;
import java.net.*;

public class java_01473_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Create stream for reading and writing to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send a welcome message to the client
            out.println("Welcome to the Socket Server!");

            // Handle each client's request
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received request: " + request);
                if (request.equalsIgnoreCase("exit")) {
                    out.println("Connection closed by client!");
                    break;
                }
                // In a real-world application, the server should handle this request
                // in a secure and repeatable way, such as by using SSL or a message queue
                // to handle asynchronous requests.
            }

            // Close the connection
            out.close();
            socket.close();
        }
    }
}