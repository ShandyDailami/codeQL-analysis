import java.net.*;
import java.io.*;

public class java_16739_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server listening on port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create new thread for client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_16739_SocketServer_A08(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            System.out.println("Error handling client " + socket.getRemoteSocketAddress());
        }
    }

    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Server received message: " + message);
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("Error handling client " + socket.getRemoteSocketAddress());
        }
    }
}