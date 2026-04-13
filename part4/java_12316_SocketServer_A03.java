import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12316_SocketServer_A03 {
    private static final int PORT = 4445;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);
            acceptClients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptClients() {
        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());
                handleClient(socket);
            } catch (IOException e) {
                e.printStackTrace();
           
            }
        }
    }

    private static void handleClient(Socket socket) {
        // Handle the client connection in a separate thread
        new ClientHandler(socket).start();
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_12316_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle client communication here
        // This is just an example, real implementation will depend on the specific requirements of the client
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) break;

                // Process the received data here
                // For example, print the data to the console
                System.out.println(new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}