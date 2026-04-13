import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05732_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                HandleClientThread thread = new HandleClientThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Server could not bind to port " + PORT);
            e.printStackTrace();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_05732_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client's request here
        // For example, you can read a request from the client and send a response back
    }
}