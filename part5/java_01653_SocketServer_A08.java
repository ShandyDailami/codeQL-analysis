import java.io.*;
import java.net.*;

public class java_01653_SocketServer_A08 {

    private static final String LOCALHOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                new HandleClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server due to " + e.getMessage());
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                System.out.println("Failed to close server due to " + e.getMessage());
            }
        }
    }
}

class HandleClientThread extends Thread {
    private Socket clientSocket;

    public java_01653_SocketServer_A08(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            // Get input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read client's request
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Send a response
            out.println("Hello, client!");
        } catch (IOException e) {
            System.out.println("Failed to handle client due to " + e.getMessage());
        }
    }
}