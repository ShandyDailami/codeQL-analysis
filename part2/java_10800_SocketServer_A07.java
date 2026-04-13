import java.io.*;
import java.net.*;

public class java_10800_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345); // Port number
            while(true) {
                Socket socket = server.accept(); // Accepting client connection
                System.out.println("Client connected");

                // Sending a welcome message
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Welcome to the server!");

                // Listening for client message
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inputLine;
                while((inputLine = in.readLine()) != null) {
                    System.out.println("Client says: " + inputLine);
                    out.println("Server says: Hello, Client!");
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}