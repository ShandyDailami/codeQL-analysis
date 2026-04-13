import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15788_SocketServer_A03 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection");
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_15788_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create a new input stream from the socket
            InputStream inputStream = socket.getInputStream();

            // Create a new reader from the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received message: " + message);

                // Perform security-sensitive operation, e.g., check for SQL injection or cross-site scripting
                if (message.contains(";") || message.contains("<") || message.contains(">")) {
                    System.out.println("Security alert: detected injection");
                }
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            System.out.println("Error handling client connection");
            e.printStackTrace();
        }
    }
}