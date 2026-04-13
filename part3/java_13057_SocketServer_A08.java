import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13057_SocketServer_A08 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create new thread for each client
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

    public java_13057_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive message from client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);

            // Send message back to client
            socket.getOutputStream().write(message.getBytes());

            // Close connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}