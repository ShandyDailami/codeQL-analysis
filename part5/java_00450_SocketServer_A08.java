import java.net.*;
import java.io.*;

public class java_00450_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Creates a socket on a specific port
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Waiting for connections on port " + PORT + "...");

        // Infinite loop to accept connections
        while (true) {
            Socket socket = server.accept();

            // Start a new thread to handle the connection
            new Thread(new SocketHandler(socket)).start();
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_00450_SocketServer_A08(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            close();
        }
    }

    public void run() {
        String message;
        try {
            // Read from the client and send a response
            while ((message = in.readLine()) != null) {
                System.out.println("Received message: " + message);
                out.println("Echo: " + message);
            }
        } catch (IOException e) {
            close();
        }
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            // Ignore close errors
        }
    }
}