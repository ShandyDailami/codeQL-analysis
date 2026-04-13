import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38729_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client connected");

                // Only allow connections from localhost
                if (socket.getInetAddress().getHostAddress().equals("127.0.0.1")) {
                    new ClientHandler(socket).start();
                } else {
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_38729_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client
    }
}