import java.net.*;
import java.io.*;

public class java_22154_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 8080; // default port

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            
            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("New client connected!");
                    
                    // Create a new thread to handle communication with the client
                    new HandleClient(socket).start();
                }
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }
}

class HandleClient extends Thread {
    private Socket socket;

    public java_22154_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            // Read message from client
            String message = reader.readLine();

            // Echo back message to client
            writer.println("Echo: " + message);

        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex.getMessage());
        }
    }
}