import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26040_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Start a new thread to handle the client's request
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public java_26040_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you can add code to handle the client's request,
                // but in this example, we just send a simple response
                socket.getOutputStream().write("Hello from server\n".getBytes());
                socket.getOutputStream().flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}