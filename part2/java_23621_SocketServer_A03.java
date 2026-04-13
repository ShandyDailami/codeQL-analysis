import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23621_SocketServer_A03 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the client connection in a new thread
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_23621_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the socket connection here
        // This is a placeholder for the actual security-sensitive operations
        try {
            while (true) {
                // Receive data from the client
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) {
                    break;
                }

                // Process the received data here
                // For simplicity, just echo back the data
                socket.getOutputStream().write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}