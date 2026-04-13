import java.io.*;
import java.net.*;

public class java_17664_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket and bind it to a port
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while (true) {
                // Accept a client connection
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread for the client
                Thread thread = new ClientThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientThread extends Thread {
    private Socket socket;

    public java_17664_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read a message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            out.println("Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}