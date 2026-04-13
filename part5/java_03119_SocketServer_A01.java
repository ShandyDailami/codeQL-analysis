import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03119_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create a new thread for each client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_03119_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read and echo back any message received
            while ((socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write("Message received".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}