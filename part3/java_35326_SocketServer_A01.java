import java.io.*;
import java.net.*;
import java.util.*;

public class java_35326_SocketServer_A01 {
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create new thread to handle client request
            ClientHandler clientHandler = new ClientHandler(socket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_35326_SocketServer_A01(Socket socket) {
        this.socket = socket;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String request;
        try {
            while ((request = reader.readLine()) != null) {
                System.out.println("Received: " + request);
                // Handle request here, you can add security-sensitive operations here, like access control

                // Send response back to client
                writer.println("Response from server: " + request);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close connection
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}