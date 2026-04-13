import java.io.*;
import java.net.*;

public class java_21939_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Binds server socket to port 8080
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read from client
                String clientMessage = in.readLine();
                System.out.println("Client says: " + clientMessage);

                // Send response back to client
                String response = "Hello, client, your message has been received!";
                out.writeBytes(response + "\n");

                socket.close(); // Close socket when done
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}