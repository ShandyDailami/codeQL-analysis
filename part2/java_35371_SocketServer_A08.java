import java.io.*;
import java.net.*;

public class java_35371_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Receive request
                String request = input.readUTF();
                System.out.println("Received: " + request);

                // Simulate integrity failure
                if (request.contains("DATABASE")) {
                    throw new RuntimeException("Simulated integrity failure");
                }

                // Send response
                String response = "OK";
                output.writeUTF(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}