import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03450_SocketServer_A03 {

    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Handle the client in a separate thread
            new Thread(new SocketHandler(socket)).start();
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_03450_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle the client, such as reading from and writing to the socket
        // This is just a placeholder, and actual implementation will depend on the specific requirements
    }
}