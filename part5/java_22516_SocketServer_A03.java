import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22516_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            // Start a new thread to handle the client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_22516_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Get the input and output streams
        try (socket
              socket.getInputStream()
              socket.getOutputStream()) {
            // Read a message from the client
            byte[] buffer = new byte[1024];
            int bytes = socket.getInputStream().read(buffer);
            if (bytes == -1) {
                return;
            }

            String message = new String(buffer, 0, bytes);
            System.out.println("Received: " + message);

            // Send a message back to the client
            String response = "Hello, " + message + "!";
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}