import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21334_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle communication with this client
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class HandleClientThread extends Thread {
        private Socket socket;

        HandleClientThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle communication with the client here
            // For simplicity, this example just closes the connection
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}