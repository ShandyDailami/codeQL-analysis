import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18655_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handle communication here
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_18655_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read data from client
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            String message = new String(bytes);
            System.out.println("Received message: " + message);

            // Send response
            String response = "Hello, client!";
            byte[] responseBytes = response.getBytes();
            socket.getOutputStream().write(responseBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}