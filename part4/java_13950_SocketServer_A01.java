import java.io.*;
import java.net.*;

public class java_13950_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            // Create new thread for each client
            new HandleClientThread(socket).start();
        }
    }

}

class HandleClientThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_13950_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error setting up I/O for a client at " + socket.getRemoteSocketAddress());
            close();
        }
    }

    public void run() {
        try {
            // Receive a message from client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a message to client
            out.println("Hello, client!");
        } catch (IOException e) {
            System.out.println("Error handling client at " + socket.getRemoteSocketAddress());
            close();
        }
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error closing connection");
        }
    }
}