import java.net.*;
import java.io.*;

public class java_29137_SocketServer_A07 {

    public static void main(String[] args) throws IOException {

        // Create a socket and bind it to a port
        ServerSocket serverSocket = new ServerSocket(4446);
        System.out.println("Server started on port 4446");

        while (true) {

            // Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a thread for each connected client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();

        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_29137_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        // Create a buffered reader and writer
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        try {
            // Read the message from the client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Authenticate the client (simulate with a simple check)
            if (message.equals("auth_me")) {
                writer.println("auth_success");
            } else {
                writer.println("auth_fail");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}