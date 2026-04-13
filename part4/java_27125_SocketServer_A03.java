import java.net.ServerSocket;
import java.net.Socket;

public class java_27125_SocketServer_A03 {

    private static final int PORT = 9999;

    public static void main(String[] args) throws Exception {

        // Step 1: Create a ServerSocket that listens on port 9999
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server started on port " + PORT);

        // Step 2: Wait for a client to connect
        while (true) {
            Socket socket = serverSocket.accept();

            // Step 3: Handle the client connection
            new Thread(new ClientHandler(socket)).start();
        }
    }

    // A handler for each client connection
    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_27125_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client request and response here
            // For the purpose of this example, we'll just send a simple message
            try {
                socket.getOutputStream().write("Hello, client!".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}