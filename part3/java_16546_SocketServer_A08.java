import java.io.*;
import java.net.*;

public class java_16546_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening on port 8000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create stream for reading data from client
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                // Create stream for writing data to client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Read from client
                String request = in.readLine();
                System.out.println("Client says: " + request);

                // Send response
                out.println("Hello client, you connected successfully");
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection");
            e.printStackTrace();
        }
    }
}