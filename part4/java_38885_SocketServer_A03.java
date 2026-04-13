import java.net.ServerSocket;
import java.net.Socket;

public class java_38885_SocketServer_A03 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here you can handle multiple clients simultaneously
                // For simplicity, we'll just echo back the data received
                // In a real application, you would likely need to handle data in a thread
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_38885_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Receive data from the client
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead < 0) {
                    System.out.println("Client disconnected");
                    socket.close();
                    return;
                }

                // Send data to the client
                String response = new String(buffer, 0, bytesRead);
                socket.getOutputStream().write(response.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}