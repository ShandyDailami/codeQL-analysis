import java.net.ServerSocket;
import java.net.Socket;

public class java_01248_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread to handle communication with the client
                HandleClientThread thread = new HandleClientThread(socket);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println("Error occurred while running the server: " + e.getMessage());
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_01248_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read the input from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();

            // TODO: Validate and sanitize the input

            // TODO: Use the sanitized input (e.g., message) to do something useful (e.g., send a response)

            // Close the connection
            socket.close();
        } catch (Exception e) {
            System.out.println("Error occurred while handling client: " + e.getMessage());
        }
    }
}