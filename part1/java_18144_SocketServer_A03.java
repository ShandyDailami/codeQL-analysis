import java.net.*;
import java.io.*;

public class java_18144_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());

            // Create a new thread for each client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_18144_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error creating streams for client: " + socket.getRemoteSocketAddress());
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            // Send a welcome message
            out.println("Welcome!");

            // Receive and echo lines of the client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println(message);
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + socket.getRemoteSocketAddress());
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}