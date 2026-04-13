import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15208_SocketServer_A03 {
    private static final int PORT = 6000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                new HandleClientConnection(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleClientConnection extends Thread {
    private final Socket socket;

    public java_15208_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // TODO: Handle client requests here, using standard libraries only.
            // Injecting is allowed, but not encouraged.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}