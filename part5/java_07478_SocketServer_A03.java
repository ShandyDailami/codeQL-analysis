import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07478_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle the client here
            // For example, handle the data received from the client
            // This will be a long-running operation, not a simple task
            new HandlerThread(socket).start();
        }
    }

    private static class HandlerThread extends Thread {
        private Socket socket;

        public java_07478_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Receive data from the client
            // This is where you'll implement the logic to prevent injection
            // For simplicity, we'll just print out the data
            try {
                byte[] bytes = new byte[socket.getInputStream().available()];
                socket.getInputStream().read(bytes);
                String data = new String(bytes);
                System.out.println("Received: " + data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}