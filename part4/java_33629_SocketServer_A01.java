import java.io.*;
import java.net.*;

public class java_33629_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Creating server socket with port 8080
        System.out.println("Server started on port 8080. Waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept(); // Accept a new client connection
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Create a new thread to handle the client communication
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_33629_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Failed to initialize input/output streams");
        }
    }

    public void run() {
        String clientMessage;
        try {
            // Read client message
            if ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                // Echo the message back to the client
                out.println(clientMessage);
            }
        } catch (IOException e) {
            System.out.println("Failed to read or write");
        }
    }
}