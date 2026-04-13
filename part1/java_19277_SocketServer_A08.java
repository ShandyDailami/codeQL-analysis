import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19277_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT, 100, InetAddress.getByName("127.0.0.1"));
            System.out.println("Server started on port: " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new ClientHandler(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_19277_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here we would typically handle requests for the client here,
        // but for simplicity, we'll just keep the socket open and wait for client requests.
        try {
            while (!socket.isClosed()) {
                socket.receive(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}