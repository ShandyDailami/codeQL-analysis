import java.io.*;
import java.net.*;

public class java_30998_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a socket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running on port 8080");

            while (true) {
                // Wait for client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Handle client communication
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("Echo: " + inputLine);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}