import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12712_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread to handle the client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_12712_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the data from the client
            byte[] data = new byte[1024];
            socket.getInputStream().read(data);

            // Simulate integrity failure here
            if (new String(data).equals("A08_IntegrityFailure")) {
                System.out.println("Integrity failure detected. Server is shutting down...");
                socket.close();
            }

            // Continue processing the data
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}