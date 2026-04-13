import java.net.ServerSocket;
import java.net.Socket;

public class java_04042_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // Create a server socket
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444...");

        while (true) {
            // Accept a new connection
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Create a new thread for each connection
            Thread thread = new Thread(new ServerThread(socket));
            thread.start();
        }
    }
}

class ServerThread implements Runnable {
    private Socket socket;

    public java_04042_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client here...
    }
}