import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40497_SocketServer_A01 {
    private static final int port = 12345;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            // Ensure the server socket is closed properly
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_40497_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
        // For now, just print out the remote address
        try {
            System.out.println("Client: " + socket.getRemoteSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}