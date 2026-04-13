import java.io.*;
import java.net.*;

public class java_21482_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Create thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_21482_SocketServer_A03(Socket socket) {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {
        String request;
        try {
            // Read request from client
            request = in.readLine();
            System.out.println("Received: " + request);

            // Process request (e.g., prevent injection attacks)
            // TODO: Implement security-sensitive operations related to A03_Injection

            // Send response back to client
            out.println("Server response: " + request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the socket
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}