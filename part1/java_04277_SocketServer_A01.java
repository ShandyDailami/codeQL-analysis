import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04277_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
           
            }

        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_04277_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Handle the socket connection here
            // This is just a placeholder, the actual implementation would depend on your specific requirements

            // Close the socket
            socket.close();

        } catch (IOException e) {
            System.err.println("Failed to handle socket connection");
            e.printStackTrace();
        }
    }
}