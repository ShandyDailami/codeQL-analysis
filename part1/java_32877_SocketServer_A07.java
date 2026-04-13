import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32877_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_32877_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // TODO: Handle client communication here
            // For now, we'll just send a message to the client
            socket.getOutputStream().write("Hello, client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}