import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12812_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Create a new thread for each client
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_12812_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle client request here using the socket
        // For example, you can read a request from the client and respond with a message
        try {
            // TODO: Replace this with the actual code to handle the request
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}