import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38165_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Handle the socket in a new thread
                new SocketHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler extends Thread {
    private Socket socket;

    public java_38165_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle the socket here...
        // This is just a placeholder.
        // You should implement the actual socket handling here.
    }
}