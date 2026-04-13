import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10284_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the client connection here
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       .
.
.
.
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_10284_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here you can handle the client's input and output
    }
}