import java.io.*;
import java.net.*;

public class java_22150_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            // Create stream objects
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            if ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Here you can implement any security sensitive operation related to injection
                // For example, we can check if the message contains a command for command injection
                // If it does, we can drop the connection
                if (clientMessage.contains("command_injection")) {
                    System.out.println("Command injection detected, disconnecting...");
                    socket.close();
                    continue;
                }

                // Here you can implement any other security sensitive operation
                // For example, we can check if the message contains a server side request forgery
                // If it does, we can drop the connection
                if (clientMessage.contains("server_side_request_forgery")) {
                    System.out.println("Server side request forgery detected, disconnecting...");
                    socket.close();
                    continue;
                }

                // If no security issues, we can now handle the message
                System.out.println("Sending message to client...");
                out.println("Server: Hello, client!");
            }

            // Close the connection
            socket.close();
        }
    }
}