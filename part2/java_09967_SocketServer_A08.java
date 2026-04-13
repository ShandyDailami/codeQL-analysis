import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09967_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_09967_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add the security-sensitive operations
            // For example, checking if the socket is secure and verifying the integrity of the data
            // This example assumes that the socket is secure

            if (socket.isSecure()) {
                System.out.println("Socket is secure");
            } else {
                System.out.println("Socket is not secure");
            }

            // Continue with the rest of the operations here...

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}