import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13821_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Starting Socket Server...");
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Waiting for client connection...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new HandleClient(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleClient extends Thread {
    private Socket socket;

    public java_13821_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read and process the request
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) break;

                // Process the request here (for example, check if it's a login request, process it)
                String request = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + request);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}