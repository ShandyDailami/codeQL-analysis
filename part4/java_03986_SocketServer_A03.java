import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03986_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080; // Change this port number to your needs

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_03986_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
        // For now, we'll just print out the client's IP address
        try {
            String clientIP = socket.getInetAddress().getHostAddress();
            System.out.println("Client IP: " + clientIP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}