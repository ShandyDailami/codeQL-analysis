import java.net.*;
import java.io.*;

public class java_41438_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a server socket and listen for client connections
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server is listening on port: 6000");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_41438_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a welcome message to the client
            out.println("Welcome to the server");

            String input;
            // Read the client's message and echo it back
            while ((input = in.readLine()) != null) {
                out.println("Echo: " + input);
            }

            // Close the socket and terminate the thread
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}