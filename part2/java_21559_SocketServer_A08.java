import java.io.*;
import java.net.*;

public class java_21559_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // port number
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected!");

            // Create streams for reading and writing
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) { // read from client
                System.out.println("Received: " + clientMessage);

                // Simulate integrity failure by sending back the same message to client
                if (clientMessage.equals("Bad Message")) {
                    writer.println("Error: integrity failure");
                    writer.close();
                    socket.close();
                    continue;
                }

                // Reply with the received message
                writer.println("Received: " + clientMessage);
            }

            // Close the streams
            writer.close();
            socket.close();
        }
    }
}