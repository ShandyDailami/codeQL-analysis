import java.io.*;
import java.net.*;

public class java_35328_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);

        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();

            System.out.println("New client connected!");

            // Create a new thread to handle the client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_35328_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a welcome message
            out.println("Welcome!");

            String message;

            // Read the client's message and echo it back
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Echo: " + message);
            }

            // Close the socket connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}