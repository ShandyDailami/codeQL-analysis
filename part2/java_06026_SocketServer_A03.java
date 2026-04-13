import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06026_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Handle the client connection here
            // You can use a thread for each client connection

            // Example:
            new Thread(() -> {
                // Handle client messages here
                // For simplicity, we'll just echo back any message

                try {
                    while (true) {
                        byte[] buffer = new byte[1024];
                        int bytesRead = socket.getInputStream().read(buffer);

                        if (bytesRead == -1) {
                            break;
                        }

                        socket.getOutputStream().write(buffer, 0, bytesRead);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Client disconnected.");
                socket.close();
            }).start();
        }
    }
}