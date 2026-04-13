import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06824_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Start new thread for handling each client
                new Handler(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    Socket socket;

    public java_06824_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read from client
            socket.getInputStream().read();

            // Send message to client
            socket.getOutputStream().write("Hello, client!".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}