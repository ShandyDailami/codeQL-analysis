import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25879_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_25879_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform security-sensitive operations like checking for integrity failure here.
                // This is a placeholder and will not actually fail the integrity check.

                // TODO: Add your security-sensitive operations here.

                // ...

                // TODO: Handle the client message here.

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}