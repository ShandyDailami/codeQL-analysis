import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08529_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create a new thread to handle the client's request
            new Thread(new ClientHandler(socket)).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_08529_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here you would handle the request from the client.
        // This is a simplistic example and does not include any security-sensitive operations.
        try {
            while ((socket.getInputStream().read()) != -1) {
                // Do nothing
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}