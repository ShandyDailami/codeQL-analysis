import java.net.Socket;
import java.net.ServerSocket;

public class java_27781_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = server.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Broken access control: only allow localhost connections
                if (!socket.getInetAddress().getHostAddress().equals("127.0.0.1")) {
                    System.out.println("Connection from " + socket.getInetAddress() + " is not allowed!");
                    socket.close();
                    continue;
                }

                // Create a new thread for each connected client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_27781_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle client's request and response here
    }
}