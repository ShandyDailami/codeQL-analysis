import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08353_SocketServer_A08 {

    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port: " + SERVER_PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Start a new thread to handle communication with the client
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_08353_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the message from the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead < 0) {
                return;
            }

            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Server received your message: " + message;
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}