import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26672_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 1234; // you can change this port number

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here you can implement authentication logic, but for simplicity we will skip it

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_26672_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle client connection and communication here
    }
}