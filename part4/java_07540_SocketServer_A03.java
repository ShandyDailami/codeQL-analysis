import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07540_SocketServer_A03 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each connection
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;
        private String clientAddress;

        public java_07540_SocketServer_A03(Socket socket) {
            this.socket = socket;
            this.clientAddress = socket.getRemoteSocketAddress().toString();
        }

        @Override
        public void run() {
            try {
                // Read the incoming message and echo it back to the client
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                    socket.getOutputStream().write(buffer, 0, bytesRead);
                    socket.getOutputStream().flush();
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}