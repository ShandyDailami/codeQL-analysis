import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10525_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Handle the client connection here
            // For simplicity, we'll just print the message received
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_10525_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the message from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();

            // We'll print the received message for now
            System.out.println("Received: " + message);

            // Respond with a simple message
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Server: Message received");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}