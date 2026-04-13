import java.io.*;
import java.net.*;

public class java_42056_SocketServer_A07 implements Runnable {
    private Socket socket;

    public java_42056_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create a new input stream from the socket
            InputStream in = socket.getInputStream();

            // Create a new reader from the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            // Read a line of the message
            String message = reader.readLine();

            // Print the message
            System.out.println("Client says: " + message);

            // Send a response to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Server says: " + message);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Bind the server to port 12345
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345...");

            // Accept a connection
            Socket socket = server.accept();

            // Create a new thread to handle the client
            Thread thread = new Thread(new SocketServer(socket));
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}