import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27853_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle client connection in a new thread
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends Thread {
        Socket socket;

        public java_27853_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Receive data from client
                socket.receive(data);
                // TODO: Handle data, for security sensitive operations, you can use SecurityManager

                // TODO: Send response to client

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}