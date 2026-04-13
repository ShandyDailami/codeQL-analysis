import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38149_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Here, we can start a new thread for each client
            // for handling the client's request
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_38149_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle the client's request here
    }
}