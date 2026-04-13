import java.net.*;
import java.io.*;

public class java_13437_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Handle the client connection in a new thread
            new Thread(new ClientHandler(socket)).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_13437_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            System.out.println("Error handling client.");
            socket.close();
        }
    }

    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Simulate a security-sensitive operation here.
                // For example, check if the client is authorized to send a message.
                if (message.equals("authorized")) {
                    out.println("Access granted.");
                } else {
                    out.println("Access denied.");
                }
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("Error handling client.");
        }
    }
}