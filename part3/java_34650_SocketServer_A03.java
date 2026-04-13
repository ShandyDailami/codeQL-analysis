import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34650_SocketServer_A03 {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle the client connection in a new thread
            new Thread(new SocketHandler(socket)).start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_34650_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Implement your server logic here
    }
}