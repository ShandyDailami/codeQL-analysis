import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18554_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
       
        } finally {
            System.out.println("Server stopped.");
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_18554_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams from socket
            // Here, we are using InputStreamReader and BufferedReader to read the client's message
            // We are also using PrintWriter to send a response back to the client
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(reader);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Here, we're just echoing back the received message.
                // However, for a more secure server, you'd want to perform some sort of authentication or encryption here.
                out.println(message);
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}