import java.net.*;
import java.io.*;

public class java_20841_SocketServer_A08 {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started at port 1234");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error in server setup: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_20841_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create a input stream to read data from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create a writer to write data back to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read a line of data from the client
            String data = in.readLine();
            System.out.println("Received: " + data);

            // Respond to the client
            out.println("Hello, client!");

            // Close the connection
            socket.close();
        } catch (IOException e) {
            System.out.println("Error in handling client: " + e.getMessage());
        }
    }
}