import java.io.*;
import java.net.*;

public class java_04176_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected!");

            // Create a new thread to handle communication
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_04176_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read the client's message
            String message = in.readLine();

            // Log the client's message
            System.out.println("Received: " + message);

            // Send a response back to the client
            out.println("Server says hello to the client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}