import java.io.*;
import java.net.*;

public class java_21568_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // Set the server port
            System.out.println("Server is listening on port 5000");

            while(true) {
                Socket socket = server.accept(); // Waiting for client
                System.out.println("Client connected");

                // Creating a new thread for handling the client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error in Server: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_21568_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // First communication with client
            String clientMessage = reader.readLine();
            System.out.println("Client message: " + clientMessage);

            // Here you can add your security-sensitive operations related to A07_AuthFailure

            // Send back a response
            output.writeUTF("Server received your message");
            output.flush();

            socket.close();
        } catch (IOException e) {
            System.out.println("Error in client handler: " + e.getMessage());
        }
    }
}