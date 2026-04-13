import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17111_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Specify port number to listen on
        int port = 4444;

        // Create a server socket and listen on the specified port
        ServerSocket server = new ServerSocket(port);

        // Accept a client connection
        Socket socket = server.accept();

        // Create a new thread for handling the client
        Thread thread = new Thread(new SocketHandler(socket));
        thread.start();
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_17111_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle the socket connection here
        // You can write code here to handle the communication between the client and server
    }
}