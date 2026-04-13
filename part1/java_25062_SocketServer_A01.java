import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25062_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT + "...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handle the client connection in a new thread
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }

    static class Handler extends Thread {
        Socket socket;

        public java_25062_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle the client connection
            // Note: This is a dummy implementation. You need to implement the real logic.
        }
    }
}