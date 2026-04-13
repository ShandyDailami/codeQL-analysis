import java.net.ServerSocket;
import java.net.Socket;

public class java_41466_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle the client by creating a new thread
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_41466_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client's request/response here
        // You can use input and output streams to communicate with the client
    }
}