import java.io.*;
import java.net.*;

public class java_36830_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            String clientMessage;

            // Read from client
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received message: " + clientMessage);

                // Process the message...
                // (This is just a placeholder for your application)

                // Send back to client
                writer.println("Server received your message: " + clientMessage);
            }

            // Close connection
            socket.close();
        }
    }
}