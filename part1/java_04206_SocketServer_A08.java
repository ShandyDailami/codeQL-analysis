import java.net.ServerSocket;
import java.net.Socket;

public class java_04206_SocketServer_A08 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port: " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_04206_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);

            System.out.println("Received message from client: " + message);

            // Send a response to the client
            String response = "Server received your message: " + message;
            socket.getOutputStream().write(response.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}