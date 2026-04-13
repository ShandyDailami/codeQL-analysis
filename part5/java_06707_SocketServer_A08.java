import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06707_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Create a new thread to handle the client communication
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_06707_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // read from the client
            // read and send a response to the client
            // close the socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}