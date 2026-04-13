import java.io.*;
import java.net.*;

public class java_06456_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 1234
        ServerSocket server = new ServerSocket(1234);

        System.out.println("Server is listening on port 1234...");

        // Main loop to accept client connections
        while (true) {
            Socket socket = server.accept();

            // Create a new thread for each client connection
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_06456_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;

        // Read a message from the client and send it back
        try {
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // TODO: Implement security-sensitive operations here
                // For example, you can check if the message is empty or if it contains a specific string

                out.println("Echo: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the client connection
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}