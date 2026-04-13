import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07825_SocketServer_A08 {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread clientThread = new Thread(new ClientHandler(socket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_07825_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message from client: " + message);

            // Send a response back to the client
            String response = "Server received your message: " + message;
            byte[] responseBytes = response.getBytes();
            socket.getOutputStream().write(responseBytes);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}