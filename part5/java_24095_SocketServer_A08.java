import java.io.*;
import java.net.*;

public class java_24095_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a new server socket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running and waiting for client connections...");

            while (true) {
                // Accept a new client
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_24095_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            out.println("Hello, client!");
            System.out.println("Sent: Hello, client!");

            // Close the connections
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}