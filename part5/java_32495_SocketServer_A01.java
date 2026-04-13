import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32495_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Now that we have a client socket, we can safely create a new thread to handle it
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_32495_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Here, we can handle the client by reading from and writing to the socket
        // For simplicity, we'll just log the client's IP address
        try {
            String clientIP = clientSocket.getInetAddress().getHostAddress();
            System.out.println("Client IP: " + clientIP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}