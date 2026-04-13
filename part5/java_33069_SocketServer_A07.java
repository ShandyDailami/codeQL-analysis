import java.io.*;
import java.net.*;

public class java_33069_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Start a new thread for handling each client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_33069_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);

                // Check for authentication failure
                if (clientMessage.contains("failure")) {
                    writer.println("Authentication failed. Please try again.");
                    writer.flush();
                    break;
                }

                writer.println("Server says: Hello, client!");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}