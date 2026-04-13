import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32419_SocketServer_A08 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            // Create a new thread for each client
            Thread t = new Thread(new ClientHandler(socket));
            t.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_32419_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client connection and data
        try {
            // Receive a message from the client
            byte[] bytes = new byte[1000];
            socket.getInputStream().read(bytes);

            String message = new String(bytes);
            System.out.println("Received: " + message);

            // Send a message back to the client
            byte[] sendBytes = message.getBytes();
            socket.getOutputStream().write(sendBytes);

            System.out.println("Sent: " + message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}